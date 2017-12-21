
# $ allows the column to be specified by name

stats[3,3]
stats[3, "Birth.rate"]

# doesn't work -- angola is data
stats["Angola", 3]
stats$Country.Name["Angola"]

#extract the column and gran the second row
stats$Internet.users[2]

# structure
str(stats)

# column input (vector input) provides all levels
levels(stats$Income.Group)

levels(stats$Country.Code)
