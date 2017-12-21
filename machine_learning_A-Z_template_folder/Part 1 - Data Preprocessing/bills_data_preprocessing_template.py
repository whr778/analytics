# Data Preprocessing Template

# Importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 1 - Data Preprocessing\\Data.csv')

# Create a matrix with all features except the last column, which is dependent ... aka y
X = dataset.iloc[:, :-1].values
                
# Create a matrix with the last column                
y = dataset.iloc[:, 3].values

# Taking care of missing data
from sklearn.preprocessing import Imputer

# create an imputer object
imputer = Imputer(missing_values='NaN', strategy='mean', axis=0)

# fix the lines with missing data
imputer = imputer.fit(X[:, 1:3])

# Replace X with the corrected data
X[:, 1:3] = imputer.transform(X[:, 1:3])             

#
# Country
#
     
# Encoding categorical data           
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelEncoder_X = LabelEncoder()
X[:,0] = labelEncoder_X.fit_transform(X[:,0])

#Categorical labels 0-3 do not really have order so they need to be split between columns
# for each distinct country using a 1 to indicate the actual country
onehotencoder = OneHotEncoder(categorical_features=[0])
X = onehotencoder.fit_transform(X).toarray()
X

# y categorical data
labelEncoder_y = LabelEncoder()
y = labelEncoder_X.fit_transform(y)


# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)
X

# Feature Scaling
from sklearn.preprocessing import StandardScaler

sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test)

# This seems idiotic here? No.. we should not do this here
#sc_y = StandardScaler()
#y_train = sc_y.fit_transform(y_train)