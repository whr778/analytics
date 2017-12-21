
#subsetting -- first 10 rows
stats[1:10,]

# rows 3 to 9
stats[3:9,]

# rows 4 and 100
stats[c(4,100),]

# DataFrame one row does not truncate names like a matrix
is.data.frame(stats[1,])

# not a data frame
is.data.frame(stats[,1])

# is a data frame
stats[,1,drop=F]
is.data.frame(stats[,1,drop=F])

head(stats)

#multiply columns
stats$Birth.rate * stats$Internet.users

# add columns
stats$Birth.rate + stats$Internet.users

# create a new column
stats$MyCalc <- stats$Birth.rate * stats$Internet.users

#test of knowledge
stats$xyz <- 1:5

# error -- vector is recycled and 195 is not divisible by 4
stats$xyz <- 1:4

# first 12 records
head(stats, n=12)

#remove column
stats$MyCalc <- NULL
stats$xyz <- NULL

head(stats)

str(stats)



