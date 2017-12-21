
?read.csv
?read.csv2

# method # 1 manually select the file
stats <- read.csv(file.choose())


# method #2 set WD and read data from there

# current working directory
getwd()

# windows
#setwd()

#mac/linux
setwd('/home/bill.roe/training/R A-Z/section5-data-frames')
getwd()

rm(stats)
stats <- read.csv('DemographicData.csv')
stats

#number of rows
nrow(stats)

# number of columns
ncol(stats)

# top 5 rows
head(stats)

# last 5 rows
tail(stats)

# structure
str(stats)

#summary
summary(stats)

# random uniform dist
runif(5)

# random normal dist
rnorm(5)

