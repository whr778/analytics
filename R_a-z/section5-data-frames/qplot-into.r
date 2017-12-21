
?qplot

setwd('/home/bill.roe/training/R A-Z/section5-data-frames')
getwd()

rm(stats)
stats <- read.csv('DemographicData.csv')

#install.packages('ggplot2')
library(ggplot2)


?qplot

stats$Internet.users
stats

# histogram -- Internet users by count
qplot(data=stats, x=Internet.users)

# categorical on x and numeric on the y
qplot(data=stats, x=Income.Group, y=Birth.rate)

# mapping it 
qplot(data=stats, x=Income.Group, y=Birth.rate, size=3)
qplot(data=stats, x=Income.Group, y=Birth.rate, size=10)

qplot(data=stats, x=Income.Group, y=Birth.rate, size=I(10))
qplot(data=stats, x=Income.Group, y=Birth.rate, size=I(3))

# wrong color
qplot(data=stats, x=Income.Group, y=Birth.rate, size=I(3), colour="blue")

# right color
qplot(data=stats, x=Income.Group, y=Birth.rate, size=I(3), colour=I("blue"))

?I()

# box plot
qplot(data=stats, x=Income.Group, y=Birth.rate, geom="boxplot")

#------------- Visualizing what we need

#scatter plot
qplot(data=stats, x= Internet.users, y=Birth.rate)

# bigger dots
qplot(data=stats, x= Internet.users, y=Birth.rate, size=I(4))

# bigger and red dots
qplot(data=stats, x= Internet.users, y=Birth.rate, size=I(4), color=I("red"))

# bigger and color by income group
qplot(data=stats, x= Internet.users, y=Birth.rate, size=I(4), color=Income.Group)

