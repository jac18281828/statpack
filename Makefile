JAVA=java
JAVAC=javac
JAVADOC=javadoc
JDOCFLAGS=-d doc
JAR=jar
RM=rm -f
CP=cp -f

STATDIR=gnu/math/statistics

JFLAGS= -O -d .



CLASSES= \
	$(STATDIR)/DistributionNotContinuous.class \
	$(STATDIR)/DistributionNotDiscrete.class \
	$(STATDIR)/Monotonicity.class \
	$(STATDIR)/ProbabilityDistribution.class \
	$(STATDIR)/DiscreteDistribution.class \
	$(STATDIR)/ContinuousDistribution.class \
	$(STATDIR)/Function.class \
	$(STATDIR)/DiscreteFunction.class \
	$(STATDIR)/ContinuousFunction.class \
	$(STATDIR)/ContinuousX.class \
	$(STATDIR)/ContinuousX2.class \
	$(STATDIR)/DiscreteX.class \
	$(STATDIR)/DiscreteX2.class \
	$(STATDIR)/BinomialDistribution.class \
	$(STATDIR)/BinomialMonotonicity.class \
	$(STATDIR)/CDF.class \
	$(STATDIR)/Expectation.class \
	$(STATDIR)/ContinuousPMF.class \
	$(STATDIR)/DiscretePMF.class \
	$(STATDIR)/PoissonDistribution.class \
	$(STATDIR)/PoissonMonotonicity.class \
	$(STATDIR)/Statistics.class \
	$(STATDIR)/CountedSet.class \
	$(STATDIR)/Variance.class

STATJAR=statpack.jar

all: clean $(STATJAR) docs testmain

clean:
	$(RM) $(STATJAR) $(CLASSES) testmain.class

docs:
	$(JAVADOC) $(JDOCFLAGS) gnu.math.statistics

testmain:   testmain.java
	$(JAVAC) -d . -classpath .;./statpack.jar $?
	$(JAVA) -classpath .;./statpack.jar testmain

$(STATJAR): $(CLASSES)
	jar -cvf $@ $?

$(STATDIR)/BinomialDistribution.class : $(STATDIR)/BinomialDistribution.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/BinomialMonotonicity.class : $(STATDIR)/BinomialMonotonicity.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/CDF.class : $(STATDIR)/CDF.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ContinuousDistribution.class : $(STATDIR)/ContinuousDistribution.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ContinuousFunction.class : $(STATDIR)/ContinuousFunction.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/Function.class : $(STATDIR)/Function.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ContinuousX.class : $(STATDIR)/ContinuousX.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ContinuousX2.class : $(STATDIR)/ContinuousX2.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DiscreteDistribution.class : $(STATDIR)/DiscreteDistribution.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DiscreteFunction.class : $(STATDIR)/DiscreteFunction.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DiscreteX.class : $(STATDIR)/DiscreteX.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DiscreteX2.class : $(STATDIR)/DiscreteX2.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DistributionNotContinuous.class : $(STATDIR)/DistributionNotContinuous.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DistributionNotDiscrete.class : $(STATDIR)/DistributionNotDiscrete.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/Expectation.class : $(STATDIR)/Expectation.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/Monotonicity.class : $(STATDIR)/Monotonicity.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/DiscretePMF.class : $(STATDIR)/DiscretePMF.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ContinuousPMF.class : $(STATDIR)/ContinuousPMF.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/PoissonDistribution.class : $(STATDIR)/PoissonDistribution.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/PoissonMonotonicity.class : $(STATDIR)/PoissonMonotonicity.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/ProbabilityDistribution.class : $(STATDIR)/ProbabilityDistribution.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/Statistics.class : $(STATDIR)/Statistics.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/Variance.class : $(STATDIR)/Variance.java
	$(JAVAC) $(JFLAGS) $?

$(STATDIR)/CountedSet.class : $(STATDIR)/CountedSet.java
	$(JAVAC) $(JFLAGS) $?
