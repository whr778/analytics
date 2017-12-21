

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
 