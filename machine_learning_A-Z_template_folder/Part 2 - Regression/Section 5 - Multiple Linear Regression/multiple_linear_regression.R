# Multiple Linear Regression

# Importing the dataset
dataset = read.csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 2 - Regression\\Section 5 - Multiple Linear Regression\\50_Startups.csv')

# Encoding categorical data
dataset$State = factor(dataset$State,
                       levels = c('New York', 'California', 'Florida'),
                       labels = c(1, 2, 3))

# Splitting the dataset into the Training set and Test set
# install.packages('caTools')
library(caTools)
set.seed(123)
split = sample.split(dataset$Profit, SplitRatio = 0.8)
training_set = subset(dataset, split == TRUE)
test_set = subset(dataset, split == FALSE)

# Feature Scaling
# training_set = scale(training_set)
# test_set = scale(test_set)

# Fitting Multiple Linear Regression to the Training set
#regressor = lm(formula = Profit ~ R.D.Spend + Administration + Marketing.Spend + State,
#               data = training_set)

# Fitting Multiple Linear Regression to the Training set -- dot is a shortcut for all independent variables
regressor = lm(formula = Profit ~ .,
               data = training_set)

# Predicting the Test set results
y_pred = predict(regressor, newdata = test_set)
summary(regressor)


#Coefficients:
#  Estimate Std. Error t value Pr(>|t|)    
#(Intercept)      4.965e+04  7.637e+03   6.501 1.94e-07 ***
# R.D.Spend        7.986e-01  5.604e-02  14.251 6.70e-16 ***
# Administration  -2.942e-02  5.828e-02  -0.505    0.617    
# Marketing.Spend  3.268e-02  2.127e-02   1.537    0.134    
# State2           1.213e+02  3.751e+03   0.032    0.974    
# State3           2.376e+02  4.127e+03   0.058    0.954    
---
#  Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1

# more stars more significant

# y is the dependent variable -- the rest are independent variables
# P-Value determines the statistical impact of the independent variable on the dependent variable
# ** The LOWER the p-value the more effect the independent variable will have on the dependent variable
  
  
#
# Building the optional model using Backward Elimination
# Remove the statistically insignificant columns < .05
#

SL = 0.05

# Fitting Multiple Linear Regression to the Training set
regressor = lm(formula = Profit ~ R.D.Spend + Administration + Marketing.Spend + State,
               data = dataset)
summary(regressor)
# Coefficients:
#   Estimate Std. Error t value Pr(>|t|)    
# (Intercept)      5.008e+04  6.953e+03   7.204 5.76e-09 ***
#   R.D.Spend        8.060e-01  4.641e-02  17.369  < 2e-16 ***
#   Administration  -2.700e-02  5.223e-02  -0.517    0.608    
# Marketing.Spend  2.698e-02  1.714e-02   1.574    0.123    
# State2           4.189e+01  3.256e+03   0.013    0.990    
# State3           2.407e+02  3.339e+03   0.072    0.943    
# ---
#   Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1

# Remove State

# Fitting Multiple Linear Regression to the Training set
regressor = lm(formula = Profit ~ R.D.Spend + Administration + Marketing.Spend,
               data = dataset)
summary(regressor)

# Coefficients:
#   Estimate Std. Error t value Pr(>|t|)    
# (Intercept)      5.012e+04  6.572e+03   7.626 1.06e-09 ***
#   R.D.Spend        8.057e-01  4.515e-02  17.846  < 2e-16 ***
#   Administration  -2.682e-02  5.103e-02  -0.526    0.602    
# Marketing.Spend  2.723e-02  1.645e-02   1.655    0.105    
# ---
#   Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1


# Remove Administration

# Fitting Multiple Linear Regression to the Training set
regressor = lm(formula = Profit ~ R.D.Spend + Marketing.Spend,
               data = dataset)
summary(regressor)

# Coefficients:
#   Estimate Std. Error t value Pr(>|t|)    
# (Intercept)     4.698e+04  2.690e+03  17.464   <2e-16 ***
#   R.D.Spend       7.966e-01  4.135e-02  19.266   <2e-16 ***
#   Marketing.Spend 2.991e-02  1.552e-02   1.927     0.06 .  
# ---
#   Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1


# remove marketing.spend

# Fitting Multiple Linear Regression to the Training set
regressor = lm(formula = Profit ~ R.D.Spend,
               data = dataset)
summary(regressor)

# Coefficients:
#   Estimate Std. Error t value Pr(>|t|)    
# (Intercept) 4.903e+04  2.538e+03   19.32   <2e-16 ***
#   R.D.Spend   8.543e-01  2.931e-02   29.15   <2e-16 ***
#   ---
#   Signif. codes:  0 '***' 0.001 '**' 0.01 '*' 0.05 '.' 0.1 ' ' 1


# Predicting the Test set results
y_pred = predict(regressor, newdata = test_set)












