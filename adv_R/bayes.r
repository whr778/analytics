#http://www.sumsar.net/files/posts/2017-bayesian-tutorial-exercises/modeling_exercise1.html

n_draw <- 100000

# Defining and drawing from the prior distribution
prior_rate <- runif(n_draw, 0, 1)

# Defining the generative model
gen_model <- function(rate) {
  subscribers <- rbinom(1, size = 16, prob = rate)
  subscribers
}

#
# Simulating the data
#

# create an empty, NA or missing values, vector
subscribers <- rep(NA, n_draw)

# populate the subscribers array
for(i in 1:n_draw) {
  subscribers[i] <- gen_model(prior_rate[i])
}

#
# Filtering out those parameter values that didn't result in the
# data that we actually observed  E.g. 6 of 16 signed up
post_rate <- prior_rate[subscribers == 6]


# Checking that there enough samples left
length(post_rate)

hist(post_rate, xlim = c(0, 1))
mean(post_rate)
quantile(post_rate, c(0.025, 0.975))
sum(post_rate > 0.2) / length(post_rate)


# This can be done with a for loop
singnups <- rep(NA, length(post_rate))
for(i in 1:length(post_rate)) {
  singnups[i] <- rbinom(n = 1, size = 100, prob = post_rate[i])
}

# But since rbinom is vectorized we can simply write it like this:
signups <- rbinom(n = length(post_rate), size = 100, prob = post_rate)

hist(signups, xlim = c(0, 100))

quantile(signups, c(0.025, 0.975))

# So a decent guess is that is would be between 20 and 60 sign-ups.
