head(stats)
stats$Internet.users < 2

filter <- stats$Internet.users < 2
filter

#displays a row evertime it finds a TRUE
stats[filter,]

# display birthrates over 40
stats[stats$Birth.rate > 40,]

# display birthrates over 40 and internet users per houshold < 2
stats[stats$Birth.rate > 40 & stats$Internet.users < 2,]

# display where income groups are high income
stats[stats$Income.Group == 'High income',]

# find the stats for malta
stats[stats$Country.Name == 'Malta',]
