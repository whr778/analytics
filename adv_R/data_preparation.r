
# get working dir
getwd()

# set working directory
#setwd("/home/bill.roe/training/adv_R/DataPreparation")
setwd("C:\\Users\\Bill\\Documents\\Training\\adv_R\\DataPreparation")

# get working dir
getwd()

# basic import
fin <- read.csv("Future-500.csv")

# advanced import -- "" is replace empty strings -- this replaces empty strings wih NA
fin <- read.csv("Future-500.csv", na.strings = c(""))

fin
head(fin)
tail(fin)
tail(fin, 10)

str(fin)
summary(fin)
summary(fin$Industry)

# Factor -- catagorical variable

# Changing from a non-factor to a factor
fin$ID

fin$ID <- factor(fin$ID)
summary(fin)
str(fin)

fin$Inception <- factor(fin$Inception)
summary(fin)
str(fin)

# -----------------------------------------------------------
# Factor Variable Trap (FVT) -- From a Factor to a non-factor
# -----------------------------------------------------------
a <- c("12", "13", "14", "12", "12")

a
typeof(a)

# convert from character to numeric
b <- as.numeric(a)
b
typeof(b)

# factor (levels) to numeric
z <- factor(c("12", "13", "14", "12", "12"))
z
typeof(z)

# wrong converts the level not the value
y <- as.numeric(z)

# Correct.way
x <- as.numeric(as.character(z))
x

#
# example of FVT
#
head(fin)
str(fin)

#fin$Profit <- factor(fin$Profit)

head(fin)
str(fin)

summary(fin)

#wrong way
#fin$Profit <- as.numeric(fin$Profit)
head(fin)
#fin$Profit <- as.numeric(fin$Profit)


# gsub() and sub()

#?sub

fin$Expenses <- gsub(" Dollars", "", fin$Expenses)
fin$Expenses <- gsub(",", "", fin$Expenses)
head(fin)
str(fin)


fin$Revenue <- gsub("\\$", "", fin$Revenue)
fin$Revenue <- gsub(",", "", fin$Revenue)
head(fin)
str(fin)


fin$Growth <- gsub("\\%", "", fin$Growth)
head(fin)
str(fin)


# character to numeric

fin$Expenses <- as.numeric(fin$Expenses)
fin$Revenue <- as.numeric(fin$Revenue)
fin$Growth <- as.numeric(fin$Growth)

head(fin)
str(fin)
summary(fin)


# -------------------------------
# missing data
# -------------------------------

# median, research, ...

typeof(fin$Expenses)
mean(fin$Expenses, TRUE)
median(fin$Expenses, TRUE)

# what is na

?NA
TRUE
FALSE

TRUE == FALSE
TRUE == 1 # true
TRUE == 5

FALSE == 4
FALSE == 0 # true

NA == TRUE # NA
NA == FALSE # NA
#NA == NA # NA

# Find missing data

# Hard way
head(fin, 24)

# identifies (TRUE/FALSE) any NA
complete.cases(fin)

#identifies NA
!complete.cases(fin)

#picks out good rows without NA
fin[complete.cases(fin),]

#picks out rows with NA
fin[!complete.cases(fin),]

# *** EMPTY is not the same as NA

# replace on import
# see advanced import

# <NA> factors
# NA not factors


# Filtering using which() for non-missing data

head(fin)
fin$Revenue == 9746272
fin[fin$Revenue == 9746272,]

?which
which(fin$Revenue == 9746272)

fin[which(fin$Revenue == 9746272),]

# filtering user is.na() for missing data


head(fin, 24)

is.na(fin$Expenses)

fin[is.na(fin$Expenses), ]


#removing records with missing data

# backup fin
fin_backup < fin

fin[!complete.cases(fin),]

# rows with missing data
fin[is.na(fin$Industry),]

# rows with complete data
fin[!is.na(fin$Industry),]


fin <- fin[!is.na(fin$Industry),]
fin

# Resetting the dataframe index value

fin
rownames(fin)
1:nrow(fin)

rownames(fin) <- 1:nrow(fin)
fin

fin < fin_backup
fin

# faster way
rownames(fin) <- NULL
fin

#
# Correct data: Factual Analysis method
#

fin[!complete.cases(fin),]
fin[is.na(fin$State),]

fin[is.na(fin$State) & fin$City == "New York" , "State"] <- "NY"

#check
fin[c(11,377),]

fin[!complete.cases(fin),]

fin[is.na(fin$State) & fin$City == "San Francisco" , "State"] <- "CA"
fin[!complete.cases(fin),]

fin[c(82,265),]
#or
fin[fin$City == "San Francisco" ,]

#
# Correct missing data: Median
# avg or mean is close
# median (middle number) is less affected by outliers

# create a filter, in this case more relevent by industry

fin[!complete.cases(fin),]
fin[,"Employees"]

# gives an NA
median(fin[,"Employees"])

# remove NAs
median(fin[,"Employees"], na.rm=TRUE)
mean(fin[,"Employees"], na.rm=TRUE)

# add filter
med_empl_retail <- median(fin[fin$Industry == "Retail","Employees"], na.rm=TRUE)
mean(fin[fin$Industry == "Retail","Employees"], na.rm=TRUE)
med_empl_retail

fin_backup <- fin
fin[is.na(fin$Employees) & fin$Industry == "Retail",]
fin[is.na(fin$Employees) & fin$Industry == "Retail", "Employees"] <- med_empl_retail


fin[fin$Industry == "Retail",]
fin[3,]

# Idustry: Financial Services
fin_backup <- fin
med_empl_finservices <- median(fin[fin$Industry == "Financial Services","Employees"], na.rm=TRUE)
mean(fin[fin$Industry == "Financial Services","Employees"], na.rm=TRUE)
med_empl_finservices

fin[is.na(fin$Employees) & fin$Industry == "Financial Services",]
fin[is.na(fin$Employees) & fin$Industry == "Financial Services", "Employees"] <- med_empl_finservices


fin[fin$Industry == "Financial Services",]
fin[330,]

# Only four rows to go ... part 2
fin_backup <- fin
fin <- fin_backup
fin[!complete.cases(fin),]

str(fin)
fin[fin$Industry == "Construction","Growth"]
med_growth_constr <- median(fin[fin$Industry == "Construction","Growth"], na.rm=TRUE)

# what is the growth across all industries
med_growth_all <- median(fin[,"Growth"], na.rm=TRUE)
med_growth_all
med_growth_constr # construction grew less than the mediam of all industries
fin[!complete.cases(fin),]

# Growth
fin[is.na(fin$Growth) & fin$Industry =="Construction",]
fin[is.na(fin$Growth) & fin$Industry =="Construction","Growth"] <- med_growth_constr
fin[8,]
fin[!complete.cases(fin),]

# Revenue 
med_revenue_constr <- median(fin[fin$Industry == "Construction","Revenue"], na.rm=TRUE)
fin[is.na(fin$Revenue) & fin$Industry =="Construction",]
fin[is.na(fin$Revenue) & fin$Industry =="Construction","Revenue"] <- med_revenue_constr
fin[c(8,42),]
fin[!complete.cases(fin),]

# Expenses (part3)
med_expenses_constr <- median(fin[fin$Industry == "Construction","Expenses"], na.rm=TRUE)
med_expenses_constr
fin[is.na(fin$Expenses) & fin$Industry =="Construction",]
fin[is.na(fin$Expenses) & fin$Industry =="Construction" & is.na(fin$Profit),"Expenses"] <- med_expenses_constr
fin[c(8,42),]
fin[!complete.cases(fin),]



# part 4 calculate missing expenses from profit and revenue
# Revenue - Expenses = profit
# Expenses = Revenue - profit

# Profit 
fin[!complete.cases(fin),]

fin[is.na(fin$Profit),]
fin[is.na(fin$Profit),"Profit"] <- fin[is.na(fin$Profit),"Revenue"] - fin[is.na(fin$Profit),"Expenses"]
fin[c(8,42),]

fin[!complete.cases(fin),]

fin[is.na(fin$Expenses),]
fin[is.na(fin$Expenses),"Expenses"] <- fin[is.na(fin$Expenses),"Revenue"] - fin[is.na(fin$Expenses),"Profit"]
fin[15,]

fin[!complete.cases(fin),]


# Visualization
#install.packages("ggplot2")
library("ggplot2")

# scatterplot by industry
p <- ggplot(data=fin)
p + geom_point(aes(x=Revenue, y= Expenses, color=Industry, size= Profit))

# industry trends
d <- ggplot(data=fin, aes(x=Revenue, y= Expenses, color=Industry))
d + geom_point() + geom_smooth(fill=NA, size=1.2)

#BoxPlots showing growth by industry

f <- ggplot(data=fin, aes(x=Industry, y=Growth,color=Industry))
f + geom_boxplot(size=1)

#extra
f + geom_jitter() + geom_boxplot(size=1, alpha =0.5, outlier.color = NA)


?complete.cases








