#Deliverable - a list with the following components
# Character:  Machine Name
# Vector:     (min,mean,max) utilization for the month
# Logical:    Has utilization ever fallen below 90% TRUE/FALSE
# vector:     All hourse where utilization is unknown (NA's)
# DataFrame:  For this machine
# Plot:       For all machines


# get working dir
getwd()

# set working directory
#setwd("/home/bill.roe/training/adv_R/DataPreparation")
setwd("C:\\Users\\Bill\\Documents\\Training\\adv_R\\Lists")

# get working dir
getwd()

# basic import
util <- read.csv("Machine-Utilization.csv")
head(util, 12)
str(util)
summary(util)


# We need actual utilization (1 - percent.idle)

# add a utilization column
util$Utilization = 1 - util$Percent.Idle
head(util, 12)

#
# Date/Times
#

# What is the date format
tail(util) # European format

#univeral date/time format
?POSIXct

# add epoch time since 1970
util$PosixTime <- as.POSIXct(util$Timestamp, format="%d/%m/%Y %H:%M")
str(util)
head(util, 12)
summary(util)


# How to rearrange columns in a dataframe

#remove old timestamp
util$Timestamp <- NULL
head(util,12)
util <- util[,c(4,1,2,3)]
head(util, 12)

#
# Lists
#
summary(util)
RL1 <- util[util$Machine == "RL1",]
summary(RL1)
RL1$Machine <- factor(RL1$Machine)
summary(RL1)


# Character:  Machine Name
# Vector:     (min,mean,max) utilization for the month
# Logical:    Has utilization ever fallen below 90% TRUE/FALSE
# vector:     All hourse where utilization is unknown (NA's)

#calculate stats
util_stats_rl1 <- c(min(RL1$Utilization, na.rm=TRUE), 
                    mean(RL1$Utilization, na.rm=TRUE),
                    max(RL1$Utilization, na.rm=TRUE))
util_stats_rl1

# Find < 90%
which(RL1$Utilization < 0.90)
length(which(RL1$Utilization < 0.90))
util_under_90 <- length(which(RL1$Utilization < 0.90)) > 0
util_under_90

list_rl1 <- list("RL1", util_stats_rl1, util_under_90)
list_rl1

# Naming components of a list

names(list_rl1)
names(list_rl1) <- c("Machine", "Stats", "LowThreshold")
names(list_rl1)
list_rl1

# Another way. Like dataframes
names(list_rl1) <- NULL
list_rl1 <- list(Machine="RL1", Stats=util_stats_rl1, LowThreshold=util_under_90)
list_rl1

# Extracting components from a list
# three ways:
# [] - will always return a list
# [[]] will return the actual object: data or value
# $ same as the [[]] but prettier


list_rl1
list_rl1[1]
list_rl1[[1]]
list_rl1$Machine

list_rl1[2]
list_rl1[[2]]
list_rl1$Stats

# list
typeof(list_rl1[2])
# array of double
typeof(list_rl1[[2]])
# array of double
typeof(list_rl1$Stats)

# access 3rd element
list_rl1
list_rl1[[2]][3]
list_rl1$Stats[3]

# Adding and deleting components from a list
list_rl1
list_rl1[4] <- "New Information"
list_rl1

# Add vector:     All hourse where utilization is unknown (NA's)
list_rl1$UnknownHours <- RL1[is.na(RL1$Utilization), "PosixTime"]
list_rl1

# Remove a component
list_rl1[4] <- NULL
list_rl1

# Notice: numeration has shifted
str(list_rl1)

# Add another component
# DataFrame:  For this machine

list_rl1$Data <- RL1
list_rl1

summary(list_rl1)

# 
list_rl1[[4]][1]
list_rl1$UnknownHours[1]


# Subsetting a list

list_rl1list[[1]]

list_rl1[1:2]

list_rl1[c(1,2,3)]
list_rl1[c(1,4)]
sublist_rl1 <- list_rl1[c("Machine", "Stats")]
sublist_rl1[[2]][2]

#Double square brackets are NOT for subsetting
# error -- double square brackets
list_rl1[[5]]


# create a timeseries plot

library("ggplot2")

p <- ggplot(data=util)
p + geom_line(aes(x=PosixTime, y= Utilization, color=Machine), size=1.2) +
  facet_grid(Machine~.) +
  geom_hline(yintercept = 0.90, color="Gray", size=1.2, linetype=3)

myplot <- p + geom_line(aes(x=PosixTime, y= Utilization, color=Machine), size=1.2) +
  facet_grid(Machine~.) +
  geom_hline(yintercept = 0.90, color="Gray", size=1.2, linetype=3)

list_rl1$Plot <- myplot
list_rl1
summary(list_rl1)
str(list_rl1)












