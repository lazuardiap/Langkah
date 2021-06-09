### Modeling to predict the disease based on the givenm symptoms ###

# Importing all the libraries
import numpy as np
import pandas as pd
import tensorflow as tf
from tensorflow import feature_column
from sklearn.model_selection import train_test_split

# Importing the csv file and make it to pandas dataframe
df_train = pd.read_csv('Training.csv')
df_test = pd.read_csv('Testing.csv')

# Split df_train into 80% df_train and 20% df_val
df_train, df_val = train_test_split(df_train, test_size=0.2)

# Grouping by prognosis column in df_train to make a list of prognosis name
prognosis_grouping = df_train.groupby(df_train['prognosis']).max()
prognosis_list = list(prognosis_grouping.index[:])

# Mapping df_train, df_val, and df_test prognosis label
map_label_dict = {}
n = 0
for prognosis in prognosis_list:
    map_label_dict[prognosis] = n
    n += 1

df_train['prognosis'] = df_train['prognosis'].map(map_label_dict)
df_val['prognosis'] = df_val['prognosis'].map(map_label_dict)
df_test['prognosis'] = df_test['prognosis'].map(map_label_dict)

# Rename the invalid column name in df_train, df_val, and df_test
df_train = df_train.rename(columns={'dischromic _patches' : 'dischromic_patches', 
                                    'foul_smell_of urine' : 'foul_smell_of_urine',
                                    'spotting_ urination' : 'spotting_urination',
                                    'toxic_look_(typhos)' : 'toxic_look_typhos'}, inplace=False)

df_val = df_val.rename(columns={'dischromic _patches' : 'dischromic_patches', 
                                'foul_smell_of urine' : 'foul_smell_of_urine',
                                'spotting_ urination' : 'spotting_urination',
                                'toxic_look_(typhos)' : 'toxic_look_typhos'}, inplace=False)

df_test = df_test.rename(columns={'dischromic _patches':'dischromic_patches', 
                                  'foul_smell_of urine' : 'foul_smell_of_urine',
                                  'spotting_ urination' : 'spotting_urination',
                                  'toxic_look_(typhos)' : 'toxic_look_typhos'}, inplace=False)

# The function for convert the dataframe into dataset
def df_to_dataset(df, shuffle=True, batch_size=32):
    df = df.copy()
    labels = df.pop('prognosis')
    ds = tf.data.Dataset.from_tensor_slices((dict(df), labels))
    if shuffle:
        ds = ds.shuffle(buffer_size=len(df))
    ds = ds.batch(batch_size)
    return ds

# Convert the dataframe into dataset
batch_size = 50
ds_train = df_to_dataset(df_train, batch_size=batch_size)
ds_val = df_to_dataset(df_val, shuffle=False, batch_size=batch_size)
ds_test = df_to_dataset(df_test, shuffle=False, batch_size=batch_size)

# Take the feature keys in ds_train and put it in the list
for feature, label in ds_train.take(1):
    columns = list(feature.keys())

# Make the feature columns of all column. The type of all values column is numeric
feature_columns = []
for header in columns:
    feature_columns.append(feature_column.numeric_column(header))

# Creata a feature_layer for the feature_column input
feature_layer = tf.keras.layers.DenseFeatures(feature_columns)

# Create the model with output layer is dense layer with 41 type of label
model = tf.keras.Sequential([
  feature_layer,                           
  tf.keras.layers.Dense(8, activation='relu'),
  tf.keras.layers.Dense(8, activation='relu'),
  tf.keras.layers.Dropout(.1),
  tf.keras.layers.Dense(41, activation='softmax')
])

# Compile the model, use sparse_categorical_crossentropy for multiple label
model.compile(optimizer='adam',
              loss= 'sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Train the model
model.fit(ds_train, validation_data=ds_val, epochs=50)

# Test the model and compare y_pred and y_test
pred = model.predict(ds_test)
y_pred = []
for prediction in pred:
    result = np.argmax(prediction)
    y_pred.append(result)
y_test = list(df_test['prognosis'].values)
print(y_pred)
print(y_test)

# Saving the model
save_dir = "C:/Users/user/bangkit-final-project/disease_prediction"
tf.saved_model.save(model, save_dir)

# Convert the model with tflite's converter
converter = tf.lite.TFLiteConverter.from_saved_model(save_dir)
converter.optimizations = [tf.lite.Optimize.DEFAULT]
tflite_model = converter.convert()
tflite_model_file = 'disease_predict_model.tflite'

with open(tflite_model_file, "wb") as f:
    f.write(tflite_model)