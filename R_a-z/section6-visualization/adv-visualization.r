
#-------- load data ---------------------------------------
getwd()
setwd("/home/bill.roe/training/R A-Z/section6-visualization")
getwd()

movies <- read.csv("Movie-Ratings.csv")
head(movies)
colnames(movies) <- c("Film", "Genre", "CriticRating", "AudienceRating", "BudgetMillions", "Year")
head(movies)
tail(movies)
str(movies)
summary(movies)

# Factors are categories

# Convert a integer to a factor
factor(movies$Year)

#reassign a column from numeric to a factor
movies$Year <- factor(movies$Year)
summary(movies)
str(movies)

# ---------------------- Aesthetics -----------

library(ggplot2)

# add aesthetics
ggplot(data=movies, aes(x=CriticRating, y=AudienceRating))


# add geometry
ggplot(data=movies, aes(x=CriticRating, y=AudienceRating)) + geom_point()

# add color
ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre)) + geom_point()

# add size
ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre, size=Genre)) + geom_point()

# add size
ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre, size=BudgetMillions)) + geom_point()


# this is #1 (we will improve it)

# ------------------------------ Plotting with Layers

# Geometries 
p <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre, size=BudgetMillions)) + geom_point()

# point
p + geom_point()
 
# line
p + geom_line()

# multiple layers
p + geom_point() + geom_line()

# multiple layers
p + geom_line() + geom_point() 

# ----------------------------- Overriding Aesthetics
q <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre, size=BudgetMillions))

# add geom layer
q + geom_point()

# override
#example 1
q + geom_point(aes(size=CriticRating))

# example 2 -- doesn't modify q just overrides the aesthetic
q + geom_point(aes(color=BudgetMillions))

# example 3 override x-axis and x-axis label
q + geom_point(aes(x=BudgetMillions)) + xlab("Budget Millions $$$")

# example 4 multiple layers
q + geom_line() + geom_point() 

#reduce line size
q + geom_line(size=1) + geom_point() 

# --------------------------- Mapping vs setting

r <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating))
r +  geom_point()
            
# add color
# 1 mapping color to a variable
r + geom_point(aes(color=Genre))

# setting color explicitly
r + geom_point(color="DarkGreen")

# ERROR:
#r + geom_point(aes(color="DarkGreen"))

#mapping
r + geom_point(aes(size=BudgetMillions))

#setting
r + geom_point(size=10)

#Error
r + geom_point(aes(size=10))

?aes

# ------------------------------- Histogram and density charts
# Geometries and Statistics
s <- ggplot(data=movies, aes(x=BudgetMillions))
s + geom_histogram(binwidth = 10)

#add color by setting
s + geom_histogram(binwidth = 10, fill="Green")

#add color by mapping
s + geom_histogram(binwidth = 10, aes(fill=Genre))

# add a border
#add color by mapping
s + geom_histogram(binwidth = 10, aes(fill=Genre), color="Black")
# >>> 3

# Density charts -- illustrates the probability density function
s + geom_density(aes(fill=Genre))
s + geom_density(aes(fill=Genre),position = "stack")


#------------------------------------ Starting Layer tips

t <- ggplot(data=movies, aes(x=AudienceRating))
t + geom_histogram(binwidth = 10, fill="White", color="Blue")

# another way -- set aesthetic later
t <- ggplot(data=movies)
t + geom_histogram(binwidth = 10,
                   aes(x=AudienceRating),
                   fill="White", 
                   color="Blue")

# >>> #4
t + geom_histogram(binwidth = 10,
                   aes(x=CriticRating),
                   fill="White", 
                   color="Blue")
# >>> #5

#skeleton for using different data sets
t <- ggplot()


#------------------------- Statistical Transformations


?geom_smooth()

u <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre))

u + geom_point() + geom_smooth(fill=NA)



# Box plots
u <- ggplot(data=movies, aes(x=Genre, y=AudienceRating, color=Genre))
u+geom_boxplot()
u+geom_boxplot(size=1.2)
u+geom_boxplot(size=1.2) + geom_point()

# Tip or Hack
u+geom_boxplot(size=1.2) + geom_jitter()

# another
u+ geom_jitter() + geom_boxplot(size=1.2, alpha=0.5)

# >>> #6


u <- ggplot(data=movies, aes(x=Genre, y=CriticRating, color=Genre))
u+geom_boxplot()
u+geom_boxplot(size=1.2)
u+geom_boxplot(size=1.2) + geom_point()

# Tip or Hack
u+geom_boxplot(size=1.2) + geom_jitter()

# another
u+ geom_jitter() + geom_boxplot(size=1.2, alpha=0.5)

# >>> #7


# ----------------- facets


# stacked bar
v <- ggplot(data=movies, aes(x=BudgetMillions))
v + geom_histogram(binwidth = 10, aes(fill=Genre), color="Black")



#faceted stacked bar
v + geom_histogram(binwidth = 10, aes(fill=Genre), color="Black") + facet_grid(Genre~.)

# varying scales
v + geom_histogram(binwidth = 10, aes(fill=Genre), color="Black") + facet_grid(Genre~., scales="free")

# faceted scatterplots
w <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, color=Genre))
w + geom_point(size=3)

#rows
w + geom_point(size=3) + facet_grid(Genre~.)

# columns
w + geom_point(size=3) + facet_grid(.~Year)

# Grid
w + geom_point(size=3) + facet_grid(Genre~Year)

# Smoother
w + geom_point(size=3) + geom_smooth() + facet_grid(Genre~Year)


# Variable point size
w + geom_point(aes(size=BudgetMillions)) + geom_smooth() + facet_grid(Genre~Year)

# 1 <<<<

# Coordinates

#limits and zoom

#limits
m <- ggplot(data=movies, aes(x=CriticRating, y=AudienceRating, size=BudgetMillions, color=Genre))
m + geom_point()
m + geom_point() + xlim(50,100) + ylim(50,100)


# wont work well always
n <- ggplot(data=movies, aes(x=BudgetMillions))
n + geom_histogram(binwidth=10, aes(fill=Genre),color="Black")
# broke
n + geom_histogram(binwidth=10, aes(fill=Genre),color="Black") + ylim(50,100)

# broke -- data cut off
n + geom_histogram(binwidth=10, aes(fill=Genre),color="Black") + ylim(0,50)


# zoom
n + geom_histogram(binwidth=10, aes(fill=Genre),color="Black") + coord_cartesian(ylim=c(0,50))


# improve number 1 visualization
w + geom_point(aes(size=BudgetMillions)) + geom_smooth() + facet_grid(Genre~Year) + coord_cartesian(ylim=c(0,100))
# 2 <<<<


# --------------- Themes

# histogram
o <- ggplot(data=movies, aes(x=BudgetMillions))
h <- o + geom_histogram(binwidth=10, aes(fill=Genre),color="Black")
h

#axis labels
h+xlab("Money Axis") + ylab("Number of Movies")

# label formatting -- Pay attention to the + signs ... they need to be at the end ... won't continue to a new line
h + xlab("Money Axis") +
    ylab("Number of Movies") +
    theme(axis.title.x = element_text(color="DarkGreen", size=30), 
          axis.title.y = element_text(color="Red", size=30))

# tick mark formatting
h + xlab("Money Axis") +
  ylab("Number of Movies") +
  theme(axis.title.x = element_text(color="DarkGreen", size=30), 
        axis.title.y = element_text(color="Red", size=30),
        axis.text.x = element_text(size=20),
        axis.text.y = element_text(size=20)
  )

?theme

#legend formatting
h + xlab("Money Axis") +
  ylab("Number of Movies") +
  theme(axis.title.x = element_text(color="DarkGreen", size=30), 
        axis.title.y = element_text(color="Red", size=30),
        axis.text.x = element_text(size=20),
        axis.text.y = element_text(size=20),
        legend.title = element_text(size=30),
        legend.text = element_text(size=20),
        legend.position = c(1,1),
        legend.justification = c(1,1)
  )




# title

#legend formatting
h + xlab("Money Axis") +
  ylab("Number of Movies") +
  ggtitle("Movie Budget Distribution") +
  theme(axis.title.x = element_text(color="DarkGreen", size=30), 
        axis.title.y = element_text(color="Red", size=30),
        axis.text.x = element_text(size=20),
        axis.text.y = element_text(size=20),
        legend.title = element_text(size=30),
        legend.text = element_text(size=20),
        legend.position = c(1,1),
        legend.justification = c(1,1),
        plot.title = element_text(color="DarkBlue", size=40, family = "Courier")
  )



#---- exam
r <- ggplot(data=movies,  aes(x=CriticRating, y=AudienceRating))
r <- ggplot(data=movies,  aes(x=CriticRating, y=AudienceRating), colour="Purple")
r + geom_point(colour="Purple")






