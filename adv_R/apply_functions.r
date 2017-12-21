

# get working dir
getwd()

# set working directory
#setwd("/home/bill.roe/training/adv_R/DataPreparation")
setwd("C:\\Users\\Bill\\Documents\\Training\\adv_R\\ApplyFunctions\\Weather Data")

# get working dir
getwd()

# basic import

Chicago <- read.csv("Chicago-F.csv", row.names=1)
head(Chicago)
summary(Chicago)

Houston<- read.csv("Houston-F.csv", row.names=1)
head(Houston)
summary(Houston)

NewYork <- read.csv("NewYork-F.csv", row.names=1)
head(NewYork)
sumamry(NewYork)

SanFrancisco <- read.csv("SanFrancisco-F.csv", row.names=1)
head(SanFrancisco)
summary(SanFrancisco)

#Check
Chicago
Houston
NewYork
SanFrancisco

# Are these dataframes
is.data.frame(Chicago)
is.data.frame(Houston)
is.data.frame(NewYork)
is.data.frame(SanFrancisco)


#Convert to matrices
Chicago <- as.matrix(Chicago)
Houston <- as.matrix(Houston)
NewYork <- as.matrix(NewYork)
SanFrancisco <- as.matrix(SanFrancisco)


is.matrix(Chicago)
is.matrix(Houston)
is.matrix(NewYork)
is.matrix(SanFrancisco)

# put all of the matrices into a list
Weather <- list(Chicago=Chicago, NewYork=NewYork, Houston=Houston, SanFrancisco=SanFrancisco)
Weather

Weather[3]
Weather[[3]]
Weather$Houston

# 1 is by row, 2 is by column
?apply

# Evaluate one city
apply(Weather$Chicago, 1, mean)
# Check
mean(Houston["DaysWithPrecip",])
apply(Weather$Chicago, 1, max)
apply(Weather$Chicago, 1, min)
apply(Weather$Chicago, 1, sum)

# the column processing doesn't make much sense on this data
apply(Weather$Chicago, 2, mean)
apply(Weather$Chicago, 2, max)
apply(Weather$Chicago, 2, sum)

#compare
apply(Weather$Chicago, 1, mean)
apply(Weather$Houston, 1, mean)
apply(Weather$NewYork, 1, mean)
apply(Weather$SanFrancisco, 1, mean)

# could use cbind, to create a table
# <<<< nearly deliverable 1, but there is a better way

# recreate apply with loops, not usually discussed
Chicago

# 1 -- long and old way -- find the mean of every row
output <- NULL
for (i in 1:5) {
  output[i] <- mean(Chicago[i,])
}

output
names(output) <- rownames(Chicago)
output

# 2 -- better way
apply(Weather$Chicago, 1, mean)



#---------------
# lapply
# --------------
?lapply
Chicago

# transpose a matrix
?t()
t(Chicago)
Weather
t(Weather$Chicago)

# allows applying across all elements of the list
lapply(Weather, t)

mynewlist <- lapply(Weather, mean)

# example2
Chicago
# add a row to Chicago
rbind(Chicago, NewRow=1:12)

# Add a new row to every element in the Weather list
lapply(Weather, rbind, NewRow=1:12)

# example 3
?rowMeans
rowMeans(Chicago)

lapply(Weather, rowMeans)

# 1 <<< nearly there to deliverable 1 result, but a better way

# handy to use with lapply
?rowMeans
?colMeans
?rowSums
?colSums

# combine lapply with [] operator
Weather
# same result accessing first column of the first row
Weather$Chicago[1,1]
Weather[[1]][1]

# grab the first row and first cell from each list element
lapply(Weather, "[",1,1)

# row access -- Grab the first row from each element in the list
lapply(Weather, "[",1,)

# Column access -- Grab the column from each element in the list
lapply(Weather, "[",,3)

# -------------------------
# Adding your own functions
# -------------------------

lapply(Weather, rowMeans)

# first row of each matrix
lapply(Weather, function(x) x[1,])

# fifth row of each matrix
lapply(Weather, function(x) x[5,])

# column 12
lapply(Weather, function(x) x[,12])

# column 12
Weather
# subtract low from high, giving the difference
lapply(Weather, function(z) z[1,] - z[2,])

# convert to percent
lapply(Weather, function(z) (z[1,] - z[2,])/z[2,])

# round to 2 decimal points
lapply(Weather, function(z) round((z[1,] - z[2,])/z[2,], 2))

#  <<<< deliverable 2, will improve


# -----------------
# sapply -- simpler version of lapply
# -----------------
?sapply

# Average high for every city in july
lapply(Weather, "[",1,7)

# returns a named vector instead of a list
sapply(Weather, "[",1,7)
sapply(Weather, rowMeans)


# average high F for 4th quarter

# returns a list
lapply(Weather, "[",1, 10:12)

# returns a matrix
sapply(Weather, "[",1, 10:12)

lapply(Weather, rowMeans)
sapply(Weather, rowMeans)

round(sapply(Weather, rowMeans), 2) # <<< Deliverable 1.

# Another example

# round to 2 decimal points
lapply(Weather, function(z) round((z[1,] - z[2,])/z[2,], 2))

# round to 2 decimal points
sapply(Weather, function(z) round((z[1,] - z[2,])/z[2,], 2)) # <<< Delieverable 2

# by the way sapply is a wrapper around lapply -- returns a list same a lapply
sapply(Weather, rowMeans, simplify = FALSE)


# ----------------------
# Nesting apply methods
# ----------------------
Weather
lapply(Weather, rowMeans)
sapply(Weather, rowMeans)

# how do we get row maximums?
?rowMeans
Chicago
apply(Chicago, 1, max)


# apply across a list
lapply(Weather, apply, 1, max)
sapply(Weather, apply, 1, max)
#same
sapply(Weather, function(x) apply(x,1, max))

sapply(Weather, apply, 1, max) # <<< Deliverable 3
sapply(Weather, apply, 1, min) # <<< Deliverable 4


#
# which.max() and which.min()
#
?which.max
?which.min

# find the max column
Chicago

# first row
Chicago[1,]

# first row column max returned
which.max(Chicago[1,])

# get the name for the returned column
names(which.max(Chicago[1,]))

# do the previous for all rows in the matrix
apply(Chicago, 1, function(x) names(which.max(x)))

# do the previous for all elelements in a list
lapply(Weather, apply, 1, function(x) names(which.max(x)))

# simplify
sapply(Weather, apply, 1, function(x) names(which.max(x))) # <<< Deliverable 5 max
sapply(Weather, apply, 1, function(x) names(which.min(x))) # <<< Deliverable 5 min


