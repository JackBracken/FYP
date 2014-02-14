Abstract 
=========

In this project I intend to compare the performance of generic reputation
algorithms using the Stack Exchange Question and Answer sites' open-sourced data
dumps. An attempt will also be made to improve upon the performance of the
algorithms, and analyse their robustness against attack.



% rewrite to mention user and performance trials, maybe remove attack part



1. Introduction (2 pages)
=========================

With the increasing use of the internet in our day-to-day tasks, it has become
more and more important that we be able to verify the trustworthiness of the
strangers we so often rely on. While the use of technologies such as public key
encryption allow us to verify \\textsl{who} we are talking to with reasonable
confidence, we are still left with the problem of determining that person's
trustworthiness as an individual---whether that be trust in their knowledge in a
particular field, or that they can be relied upon to deliver a good or service
to satisfaction.

To that end there has been considerable recent research into the fields of
peer-to-peer trust and user reputation systems in social networks (McNally,
O'Mahony and Smyth 2013; Cheng and Vassileva 2005; Mui 2002).

There are numerous contexts in which a measure of trust is desired online, from
internet transactions to online tutorials. For the purposes of this project we
will be focusing on the exchange of knowledge and expertise between users on the
Stack Exchange Question and Answer network. We define trust as the likelihood
that the user answering a question is knowledgeable on the subject matter at
hand. User reputation will refer to a numerical score allocated to a user
indicating their trustworthiness.

In this project, I will be implementing a number of generic approaches to
reputation (Weighted Sum; Hubs and Authorities, or HITS; and PageRank) upon a
graph made up of \\textsl{collaboration events} [TODO: explain collaboration
events] and comparing their performance on the Stack Exchange datasets to each
other and to the Stack Exchange reputation model (McNally, O'Mahony and Smyth
2013).

\\section{Evolution of the Web}

[N.B. this entire paragraph written from memory, I need to fact check and find
sources, although I don't believe there are any inaccuracies]



evolution of the user driven web (motivates on need for trust/rep)
------------------------------------------------------------------

When the web first exploded into widespread use in the nineties, it was a very
static compilation of pages connected by hyperlinks. Typically, websites were
only published by universities, government organisations and corporations, with
content being controlled by their respective webmasters. It was much easier,
then, to evaluate the trusworthiness of online resources; content related to
hardware published by IBM was likely to be accurate, but IBM's advice on
cake-baking may be taken with a pinch of salt (or perhaps not, as the casemay
be).

Over time however, as computers became more sophisticated; so-called web 2.0
technologies such as PHP and javascript evolved; and the number of internet
users exploded, [TODO: get actual figures] the roles of producer and consumer
are no longer so rigidly defined as they once were. Instead, anyone can post on
a social network, publish a music review to potentially millions of people, or
share off-colour remarks on a video of a cat falling from a ledge.

For the large part this is not very often an issue, as many of these forms of
communication are entirely, and transparently, opnional, but when a user, Alice,
asks a dog lovers' web-forum how much chocolate is safe to feed to her
chihuahua, she may get a range of different answers. Bob gives her the correct
answer and Mallory, out of some sense of bizzare schadenfreude, intentionally
gives her a malicious answer framed as genuine advice. Alice not know who to
trust, but errs on the side of caution.

While the above example is contrived, it illustrates the potential dangers of
the social web, and how important it is to attach an accurate reputation to
users.

[TODO: add citations to the above]




