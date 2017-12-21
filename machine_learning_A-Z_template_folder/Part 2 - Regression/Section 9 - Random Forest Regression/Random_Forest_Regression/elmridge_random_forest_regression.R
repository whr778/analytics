# Random Forest Regression

# Importing the dataset

#All
dataset = read.csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 2 - Regression\\Section 9 - Random Forest Regression\\Random_Forest_Regression\\18elmridge.csv')

#2017
#dataset = read.csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 2 - Regression\\Section 9 - Random Forest Regression\\Random_Forest_Regression\\18elmridge2017.csv')

#2017 updated
#dataset = read.csv('C:\\Users\\Bill\\Documents\\Training\\Machine Learning A-Z Template Folder\\Part 2 - Regression\\Section 9 - Random Forest Regression\\Random_Forest_Regression\\18elmridge2017-updated.csv')
dataset = dataset[1:9]
#dataset = dataset[updated == 1]

# Splitting the dataset into the Training set and Test set
# # install.packages('caTools')
# library(caTools)
# set.seed(123)
# split = sample.split(dataset$Salary, SplitRatio = 2/3)
# training_set = subset(dataset, split == TRUE)
# test_set = subset(dataset, split == FALSE)

# Feature Scaling
# training_set = scale(training_set)
# test_set = scale(test_set)

# Fitting Random Forest Regression to the dataset
install.packages('randomForest')
library(randomForest)
set.seed(1234)
xx = dataset[1:8]
y = dataset$sale_price
regressor = randomForest(x = dataset[1:8],
                         y = dataset$sale_price,
                         ntree = 500)

#square_feet,bedrooms,baths,acres,neighborhood,year_built,garage_cars,updated,sale_price,year_sold
#[2494,4,2.5,0.59,2,1988,2,1]
# Predicting a new result with Random Forest Regression
y_pred = predict(regressor, data.frame(square_feet = 2494, 
                                       bedrooms = 4.5,
                                       baths = 2.5,
                                       acres = 0.59,
                                       neighborhood = 3.0,
                                       year_built = 1988,
                                       garage_cars = 2.0,
                                       updated = 1))

# Visualising the Random Forest Regression results (higher resolution)
# install.packages('ggplot2')
library(ggplot2)
x_grid = seq(min(dataset$square_feet), max(dataset$square_feet), 0.01)
ggplot() +
  geom_point(aes(x = dataset$square_feet, y = dataset$sale_price),
             colour = 'red') +
  geom_line(aes(x = x_grid, y = predict(regressor, newdata = data.frame(square_feet = x_grid))),
            colour = 'blue') +
  ggtitle('Truth or Bluff (Random Forest Regression)') +
  xlab('square_feet') +
  ylab('sale_price')
