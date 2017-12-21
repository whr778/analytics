#Load CountryRegionVectors.r

# Each of these are  vectors Codes_2012_Dataset, Codes_2012_Dataset, Regions_2012_Dataset
# load into a data frame
mydf <- data.frame(Codes_2012_Dataset, Codes_2012_Dataset, Regions_2012_Dataset)
mydf

head(mydf)

# Change the column names
colnames(mydf) <- c("Country", "Code", "Region")

head(mydf)

rm(mydf)

# load the dataframe and change the column names
mydf <- data.frame(Country=Codes_2012_Dataset, Code=Codes_2012_Dataset, Region=Regions_2012_Dataset)
mydf
head(mydf)
tail(mydf)
summary(mydf)


#---------------merging data frames
head(stats)
head(mydf)

# how do we combine the data frames?
merged <- merge(stats, mydf, by.x="Country.Code", by.y="Code")

head(merged)

merged$Country <- NULL
colnames(merged)
head(merged)
str(merged)

# qplot advanced
qplot(data=merged, x=Internet.users, y=Birth.rate)
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region)

#shapes
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(17))
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(2))
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(15))
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(23))

# transparency -- alpha -- 0 to 1
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(19), alpha=I(0.1))
qplot(data=merged, x=Internet.users, y=Birth.rate, color=Region, size=I(5), shape=I(19), alpha=I(0.6))

#title
qplot(data=merged, x=Internet.users, y=Birth.rate, 
      color=Region, size=I(5), shape=I(19), alpha=I(0.4),
      main="Birth rate vs Internet users")












