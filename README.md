# Final Year Project

## Reputation Algorithms for the Social Web

### Project Information

The social web reflects an important paradigm shift in the nature of our online transactions. We increasingly rely on the opinions of others to mediate these transactions and as such the reliability of these users becomes an important indicator of quality. Thus, the concept of user reputation has become increasingly important in the context of today’s social web. Recently, there has been considerable research on various approaches to model the reputation of users as they participate in a diverse array of online interactions.

The goal of this project is to design, implement and evaluate reputation algorithms for users of the [Stack Exchange](http://stackexchange.com/) network, a popular group of social Q&A sites. There are currently over 80 topical Stack Exchange websites, hosting almost 2 million users. Some 3.8 million questions have been posed, eliciting 7.7 million answers. Users are permitted to post questions that can be answered by other users in the community. Each answer given can be voted up or down by others and the questioner can chose to highlight a single answer as correct, indicating the question has been answered satisfactorily or that answer was the best answer provided. The availability of such data can be leveraged to estimate the reputation of users; for example, if the answers provided by a particular user are frequently deemed to be correct and/or receive many positive votes from the community, then this provides an indication that the user is knowledgeable about particular subject matters.

### Project Goals

#### Madatory

* Download [Stack Exchange data](http://data.stackexchange.com/) - data from three sites should be obtained.
* Implementation of reputation algorithms from the literature.
* Evaluation: for each dataset, compare the performance of these algorithms to the user reputation model currently used on Stack Exchange.

#### Discretionary

* Predict the correct answers to questions based on user reputation.
* Evaluate the accuracy of predicted answers.
* Perform user-trials and correlate prediction performance with offline metrics.

#### Exceptional

Any (but not limited to) the following:
* Propose and implement enhancements to improve algorithm performance.
* Analyse the robustness of the reputation algorithms against attack.

### Setup

#### Database

Download and install [PostgreSQL](http://www.postgresql.org/download/).

For now, the database is name ```fyp``` and is owned by a user name ```karma```.

    $ sudo -u postgres psql  
    psql (9.1.9)
    Type "help" for help.
    
    postgres=# CREATE USER karma WITH PASSWORD 'karma';
    CREATE ROLE
    postgres=# CREATE DATABASE fyp OWNER karma;
    CREATE DATABASE
    postgres=# GRANT ALL PRIVILEGES ON DATABASE fyp TO karma;
    GRANT
    postgres=# \q

#### Oracle JDBC

Download the jar somewhere safe. If using eclipse, install the artifact with ```File -> Import -> Maven -> Install or deploy an artifact to a Maven repository``` and fill in the appropriate details. 

If not using eclipse's m2e, install it to the local mvn repo with the command

    mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.1 \
    -Dpackaging=jar -Dfile=ojdbc6.jar -DgeneratePom=true```.
