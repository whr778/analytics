# Multiple Linear Regression

# Importing the libraries
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 2 - Regression\\Section 5 - Multiple Linear Regression\\50_Startups.csv')
X = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 4].values

# Encoding categorical data
# Encoding the Independent Variable
from sklearn.preprocessing import LabelEncoder, OneHotEncoder
labelencoder_X = LabelEncoder()
X[:, 3] = labelencoder_X.fit_transform(X[:, 3])
onehotencoder = OneHotEncoder(categorical_features = [3])
X = onehotencoder.fit_transform(X).toarray()

# Avoiding the Dummy Variable Trap
X = X[:, 1:]

# Splitting the dataset into the Training set and Test set
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 0)

# Feature Scaling
"""from sklearn.preprocessing import StandardScaler
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)
X_test = sc_X.transform(X_test)
sc_y = StandardScaler()
y_train = sc_y.fit_transform(y_train)"""

# Fitting Multiple Linear Regression to the Training set
from sklearn.linear_model import LinearRegression
regressor = LinearRegression()
regressor.fit(X_train, y_train)

# Predicting the Test set results
y_pred = regressor.predict(X_test)

#
# Building an optimal model using Backward Elimination
#

# y is the dependent variable -- the rest are independent variables
# P-Value determines the statistical impact of the independent variable on the dependent variable
# ** The LOWER the p-value the more effect the independent variable will have on the dependent variable


# Get the rows and columns
rows, columns = X.shape

# X - intercept 1's
# change b0 to b0X0 ... b1X1
# add add a column of 1's 
# add X matrix to the new matrix of ones -- that way the ones are on column 0
X = np.append(arr = np.ones((rows,1)).astype(int), axis = 1, values = X)

# significance level
SL = 0.05

# All columns
X_opt = X[:,[0,1,2,3,4,5]]

# need stats models library
import statsmodels.formula.api as sm
regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
regressor_OLS.summary()

#==============================================================================
                 #coef    std err          t      P>|t|      [95.0% Conf. Int.]
#------------------------------------------------------------------------------
#const       5.013e+04   6884.820      7.281      0.000      3.62e+04   6.4e+04
#x1           198.7888   3371.007      0.059      0.953     -6595.030  6992.607
#x2           -41.8870   3256.039     -0.013      0.990     -6604.003  6520.229
#x3             0.8060      0.046     17.369      0.000         0.712     0.900
#x4            -0.0270      0.052     -0.517      0.608        -0.132     0.078
#x5             0.0270      0.017      1.574      0.123        -0.008     0.062
#==============================================================================

# Remove X2
X_opt = X[:,[0,1,3,4,5]]

# need stats models library
import statsmodels.formula.api as sm
regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
regressor_OLS.summary()

#==============================================================================
 #                coef    std err          t      P>|t|      [95.0% Conf. Int.]
#------------------------------------------------------------------------------
#const       5.011e+04   6647.870      7.537      0.000      3.67e+04  6.35e+04
#x1           220.1585   2900.536      0.076      0.940     -5621.821  6062.138
#x2             0.8060      0.046     17.606      0.000         0.714     0.898
#x3            -0.0270      0.052     -0.523      0.604        -0.131     0.077
#x4             0.0270      0.017      1.592      0.118        -0.007     0.061
#==============================================================================
# Remove X1,X2
X_opt = X[:,[0,3,4,5]]

# need stats models library
import statsmodels.formula.api as sm
regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
regressor_OLS.summary()

#==============================================================================
                 #coef    std err          t      P>|t|      [95.0% Conf. Int.]
#------------------------------------------------------------------------------
#const       5.012e+04   6572.353      7.626      0.000      3.69e+04  6.34e+04
#x1             0.8057      0.045     17.846      0.000         0.715     0.897
#x2            -0.0268      0.051     -0.526      0.602        -0.130     0.076
#x3             0.0272      0.016      1.655      0.105        -0.006     0.060
#==============================================================================

# Remove X1,X2, X4
X_opt = X[:,[0,3,5]]

# need stats models library
import statsmodels.formula.api as sm
regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
regressor_OLS.summary()

#==============================================================================
 #                coef    std err          t      P>|t|      [95.0% Conf. Int.]
#------------------------------------------------------------------------------
#const       4.698e+04   2689.933     17.464      0.000      4.16e+04  5.24e+04
#x1             0.7966      0.041     19.266      0.000         0.713     0.880
#x2             0.0299      0.016      1.927      0.060        -0.001     0.061
#==============================================================================

# Remove X1, X2, X4, X5
X_opt = X[:,[0,3]]

# need stats models library
import statsmodels.formula.api as sm
regressor_OLS = sm.OLS(endog = y, exog = X_opt).fit()
regressor_OLS.summary()
















