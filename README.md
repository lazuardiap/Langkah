# Langkah

This is a product that produce during 2021 bangkit capstone project. Langkah itself is a product based on healthcare theme that provided by health ministry of Indonesia and focus on helping people reach nearby hospital and give info about them. The different between Langkah and other competitors such as Halodoc and Alodokter is Langkah only focused towards relationship between patient and hospital, not the doctors. For the emergency situation, Langkah provide emergency call feature that can be used on nearest hospital based on google maps, then you also can choose one of the hospital to call. 

Then the last feature is to make an appointment with nearby hospital based on complaints that you gave to us. Langkah use Machine Learning with data structure to detect any disease based on answered yes/no question provided in the product. Right after patients answer the questions, Langkah will give the best polyclinics recomendation based on your disease.

# How to replcate

The steps may changes from time to time android studio or kotlin are updated. 

First of all, this git repository based on 3 branches, master, ui-only, and backend. The way we work is simply just updating Front-end and Back-end separatly. But there are some problems that may occur, and those are:
1. The differ between android studio and kotlin version
2. Firebase account that need to integrate first wether you work on FE or BE.
3. Machine Learning implementation (this will make the work collapse because you'll have to really work together as front-end and back-end, the components is mixed between FE and BE)

## Step 1

Make sure to finish the authetication page (login / sign up/ lazy sign up) from both side (FE and BE), especially if you work on FE but the BE didn't start yet, so then BE will follow your available page that merged on master. Otherwise your progress will left behind schedule. 

Just to make sure, person that responsible for FE must work faster than person who responsible for BE. Because everything will follow the person behind FE, and double check with the design you made.

## Step 2

During the process of building the app, comunicate with your Cloud division to discuss about GCP, and even SQL on firebase. You can use any dummy data, but for future work you need real time database such as firebase to operate. Also keep in mind that using service from GCP may cost you money, so don't bother to test often.

## Step 3

If you work the Machine Learning part at the end, make sure to communicate with your Machine Learning division, because maybe your ML division didn't understand how to implement the model. To be honest, you should work on that ML part as soon as posible, because it will take time.

## Step 4

At the end, don't forget to run any test that you have to do. Make sure that the product run well, and can be used or maybe help people around you!

# Future Works

This repository is not perfect and have not been deployed yet, our team didn't work using any specific pattern for building the product, but maybe this product can be build using MVVM model. The database may not perfect because we only use Dummy Data not directly from Firebase integrated with real time data from the government. Then, the ML part is just not right to be called "Best Practice" for UX. It contain 130 questions, and patient have to answer all of those questions first before Langkah can process their complaints. Even if you just answer "no", that because the model based on Sklearn and we migrate using Tensorflow for TFLite purpose. If you can fix the ML Part then the app should be perfect for deployment. The design can be changed for better UX as you please.



Regards, New Shelter team
