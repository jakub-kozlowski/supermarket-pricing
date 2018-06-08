# supermarket-pricing

This is standard maven project created from the `quickstart` archetype.

It can be run through `PricingApp.main` although it has no UI at the moment
and it's sole purpose is to demo source growth, so the best way to get an
idea about the design is to run `mvn test`.

## Decisions
* not using Mockito in favour of inner stub/mock classes - this few cases
test doubles were required did not justify including the dependency
* ignored grouping weighted items - alternative decision would be grouping weighted
items and adding same items weight, which could give different final price due to rounding