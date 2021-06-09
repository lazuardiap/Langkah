### Modeling to predict the disease based on the givenm symptoms ###

# Importing all the libraries
import numpy as np
import pandas as pd
import tensorflow as tf

# Importing the csv file and make it to pandas dataframe
df_train = pd.read_csv('Training.csv')
df_test = pd.read_csv('Testing.csv')

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

#Split columns and label to x and y
column_list = list(df_train.columns)
x_train = df_train.drop(columns=['prognosis'])
y_train = df_train.drop(columns=column_list[:-1])

x_test = df_test.drop(columns=['prognosis'])
y_test = df_test.drop(columns=column_list[:-1])

# Create the model with output layer is dense layer with 41 type of label
model = tf.keras.Sequential([
  tf.keras.layers.InputLayer(input_shape=(1, 132)),                           
  tf.keras.layers.Dense(8, activation='relu'),
  tf.keras.layers.Dense(16, activation='relu'),
  tf.keras.layers.Dropout(.1),
  tf.keras.layers.Dense(41, activation='softmax')
])

# Compile the model, use sparse_categorical_crossentropy for multiple label
model.compile(optimizer='adam',
              loss= 'sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Train the model and split the validation to 0.2 with 30 epochs
model.fit(x_train, y_train, validation_split=0.2, epochs=30)

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
