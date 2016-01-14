# Critiques

## Readability
What pieces of code help versus obscure your understanding of the algorithm?
What comments might be helpful within the code?
Are there places where the code could be more concise and also more clear?

### Good
* `Disk.java` is really well-commented
* The testing format is really interesting to compare the trade-offs of the
two methods
*

### Bad
* Main method in `Bins.java` has no comments. Confusing
* `Disk.java`'s equals method could be majorly simplified.

### Discussion
`Disk.java`'s equals method has a really long and complicated boolean expression,
but simplifying it into a one liner makes it a little bit harder to process when
glancing through the code. The more concise format (one-liner), definitely
looks nicer to us however.

The Constructors in `Disk.java` have redundant definitions of the capacity of
the disk. So because the capacity is unchangeable and is a constant, it should
be set as a `private static final` variable because the value does not change
between instances of the class, nor over the lifecycle of the various instances.


## Testability
How would you test this code for bugs?
Give a specific example of a "test case" as the code is currently written.
What additional functions may be helpful?
Give a specific example of a "test case" for your new function.

### Suggestions
To test the code, you could add a method that ensures that the suggested
file arrangements do not violate the size constraints of the various disks.

### Test Cases
* 500,000 kb and 500,001 kb files to ensure placed on two disks.
* 10 99,999 kb files all places on 1 disk
* Test that have files listed in non-optimal order, to see if optimal order /
grouping can be achieved by algorithm.


## Extensibility
What Code Smells can you find?
What suggestions does this code make about how someone would extend it in the future to compare the performance of a wider variety of fitting algorithms?
What dependencies are there between different parts of the code?
How easy to find are those dependencies?
Can you clarify or remove those dependencies?

### Suggestions
We were thinking that in order to promote good extensibility, we should
refactor the testing code to involve a variety of heuristics.

If you are trying to test a lot of different methods of stacking bins,
then you should define an interface `BinMethod` that has one method `stack()`
that returns a boolean. Then many implementations of this Interface can be dropped
into the live code and work perfectly with minimal changes. You would also have
to refactor the remaining code to have various outcomes wrapped in a method to
create more DRY code (Don't Repeat Yourself). 

Disk size should be changeable, or be otherwise set as a final.
