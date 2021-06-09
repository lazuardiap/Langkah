# Langkah

This is a product that produces during the 2021 bangkit capstone project. Langkah itself is a product based on a healthcare theme provided by the health ministry of Indonesia and focuses on helping people reach a nearby hospital and give info about them. The difference between Langkah and other competitors such as Halodoc and Alodokter is Langkah only focused on the relationship between patients and the hospital, not the doctors. For the emergency, Langkah provides an emergency call feature that can be used on the nearest hospital-based on google maps, then you also can choose one of the hospitals to call.

Then the last feature is to make an appointment with a nearby hospital based on complaints that you gave to us. Langkah uses Machine Learning with a data structure to detect any disease based on answering yes/no questions provided in the product. Right after patients answer the questions, Langkah will give the best polyclinics recommendation based on your disease.

# How to replicate

The steps may changes from time to time android studio or kotlin are updated.

First of all, this git repository is based on 3 branches, master, ui-only, and backend. The way we work is simply just updating Front-end and Back-end separately. But some problems may occur, and those are:
1. The differ between android studio and the kotlin version
2. Firebase account that needs to integrate first whether you work on FE or BE.
3. Machine Learning implementation (this will make the work collapse because you'll have to work together as front-end and back-end, the components are mixed between FE and BE)

## Step 1

Make sure to finish the authentication page (login / sign up/ lazy sign up) from both sides (FE and BE), especially if you work on FE but the BE didn't start yet, so then BE will follow your available page that merged on master. Otherwise, your progress will be left behind schedule.

Just to make sure, the person that responsible for FE must work faster than the person responsible for BE. Because everything will follow the person behind FE and double-check with the design you made.

## Step 2

During the process of building the app, communicate with your Cloud division to discuss GCP and even SQL on firebase. You can use any dummy data, but for future work, you need a real-time database such as firebase to operate. Also keep in mind that using a service from GCP may cost you money, so don't bother to test often.

## Step 3

If you work the Machine Learning part at the end, make sure to communicate with your Machine Learning division, because maybe your ML division didn't understand how to implement the model. To be honest, you should work on that ML part as soon as possible, because it will take time.

## Step 4

In the end, don't forget to run any test that you have to do. Make sure that the product runs well, and can be used or maybe help people around you!

# Future Works

This repository is not perfect and has not been deployed yet, our team didn't work using any specific pattern for building the product, but maybe this product can be build using the MVVM model. The database may not perfect because we only use Dummy Data not directly from Firebase integrated with real-time data from the government. Then, the ML part is just not right to be called "Best Practice" for UX. It contains 130 questions, and patients have to answer all of those questions first before Langkah can process their complaints. Even if you just answer "no", that because the model is based on Sklearn and we migrate using Tensorflow for TFLite purposes. Further research has been put by applying TF random forest which provides a similar version of decision tree we've had using Sklearn. The problem by then is that we're having a problem in deploying such a model into android. With TF random forest we decrease the number of questions to 40+ questions out of 130 questions we use to have. Since TF random forest is new to the Tensorflow circuit, we couldn't convert it to tflite. If you can fix the ML Part then the app should be perfect for deployment. The solution might be to put our model with TF serving. The design can be changed for better UX as you please.



Regards, New Shelter team
