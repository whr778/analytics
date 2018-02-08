# -*- coding: utf-8 -*-
"""
Created on Wed Dec 27 10:44:46 2017

@author: n35457
"""

import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

sns.set(color_codes=True)
#%matplotlib inline

df = pd.read_csv('iris.data')

df.head()

#?pd.read_csv()

df = pd.read_csv('iris.data', header=-1)

df.head()
col_name =  ['sepal_length', 'sepal_width','petal_length', 'petal_width', 'species']
#      -- Iris Setosa
#      -- Iris Versicolour
#      -- Iris Virginica
col_name
df.columns = col_name
df.head()

# Iris dataset from seaborn -- doesn't work from this network
#iris = sns.load_dataset('iris')
#iris.head()
#iris.describe()


df.describe()
print(df.info())
print(df.groupby('species').size())
sns.pairplot(df, hue='species', size=3, aspect = 1);

df.hist(edgecolor='black', linewidth=1.2, figsize=(12,8))
plt.show()

plt.figure(figsize=(12,8));
plt.subplot(2,2,1)
sns.violinplot(x='species', y='sepal_length', data=df)
plt.subplot(2,2,2)
sns.violinplot(x='species', y='sepal_width', data=df)
plt.subplot(2,2,3)
sns.violinplot(x='species', y='petal_length', data=df)
plt.subplot(2,2,4)
sns.violinplot(x='species', y='petal_width', data=df)
plt.show()

df.boxplot(by='species', figsize=(12,8))

pd.plotting.scatter_matrix(df,figsize=(12,10))
plt.show() 

#np.random.randn?
x = 10 * np.random.rand(100)
y = 3 * x + np.random.randn(100)
plt.figure(figsize = (10, 8))
plt.scatter(x, y);
from sklearn.linear_model import LinearRegression
model = LinearRegression(fit_intercept=True)
model

X = x.reshape(-1, 1)
X.shape
model.fit(X, y)

model.coef_

model.intercept_


x_fit = np.linspace(-1, 11)
X_fit = x_fit.reshape(-1,1)
y_fit = model.predict(X_fit)

plt.figure(figsize = (10, 8))
plt.scatter(x, y)
plt.plot(x_fit, y_fit);



















