# 2. Background Research (6 pages? / 3000 words)

## 2.1 Introduction

In the following chapter I outline the research I have undertaken so far
on online reputation systems.

I define trust and reputation, and briefly explain their differences and
why drawing a distinction between the two is important. I briefly
describe the user reputation algorithms that are currently in use across
the web, and go into further detail on the algorithms I will be
evaluating. Finally, I will present a number of case studies on sites
that use a user reputation model, such as the Stack Exchange Network,
ebay and Haystaks.

## 2.2 Trust and Reputation

For the purposes of this project, *trust* is defined as a relationship
between two parties. A trustor is an entity who places a certain amount
of faith in the actions or knowledge of another entity, (or the
trustee). Trust is not a symmetric relationship, so while, for example,
a student may trust a teacher's knowledge in their subject matter, the
teacher will likely have less (or no) trust in their student's knowledge
(McNally, O'Mahony and Smyth 2013).

Trust can occur between numerous types of entities, such as between
people or web-pages (Page, L., Brin S., Motwani, R., and Winograd, T.
1999). It is inherently a difficult property to quantify in any accurate
way, and is why the need to draw a distinction between *trust* and
*reputation* arises.

For the purposes of this paper, *reputation* is defined as a numeric
measure of a user's *trustworthiness* according to some metric performed
on their individual trust scores (McNally, O'Mahony and Smyth 2013).

There are a number of generic and ad-hoc implementation across the web,
such as Google's PageRank algorithm for measuring a web-page's
importance, Stack Exchange's bespoke system based on user activity, or
ebay's implementation which uses user reviews to calculate reputation.

## 

## 2.3 Reputation Algorithms

### 2.3.1 TrustRank

## 2.4 Case Studies

### 2.4.1 Stack Exchange

The Stack Exchange network is a network of Question and Answer (Q\\&A)
communities, each focused on a specific field of expertise, with one for
everything from programming to bicycling and cooking. As of the time of
writing this report, the network consists of 114 Q\\&A sites, almost 4.5
million users and over 8 million questions with 14.6 million answers.

In the Stack Exchange system, reputation is calculated as a sum of
points earned by contributing to the sites in various ways. Nearly every
site activity, from asking and answering questions, to suggesting edits
and flagging content for moderation, can earn the user points. This
system is aimed more towards encouraging activity than accurately
evaluating a user's trust.

All content on the Stack Exchange network is published under a Creative
Commons Attribution Share Alike license, and every three months an
anonymized data dump of all the questions and answers on every site is
publicly released. Each site is divided into a collection of XML files
for the different objects. The ones we are primarily interested in are
the Posts.xml and Users.xml files. The other files deal with edit
history, comments, and in-site rewards that are unneccesary for this
project.

### 2.4.2 ebay

### 2.4.3 Klout

### 2.4.4 HayStaks

## Collaboration Events (???)

In the context of user interactions, we can define a so-called
\\textsl{collaboration event} between two entities. When entity A
interacts with the collection of entities C, A then produces a
reputation score for each entity in the collection C.

As we look at these events as a whole for a social network, they form a
weighted directed graph of collaboration events, with the users
represented by nodes, and reputation scores by the edges between nodes.
There can potentially be numerous edges between the same two nodes in
both directions, in which case we combine these scores so that there are
at most two edges between two nodes (one for each direction).
