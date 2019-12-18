package com.tests.day11;

public class notes {
    /*
    Agenda: Synchronization
Waits in selenium: Implicit, Explicit, Fluent
If selenium is coming before element appear - you will get NoSuchElementException
Synchronization is one the biggest issues in Selenium WebDriver. Selenium doesn't adjust automatically.
To overcome these issues we used to use Thread.sleep(2000)
What's the problem with this solution?
Thread.sleep(2000) will stop your test script, no matter element is available or no for fixed amount of time.
Thread.sleep(20000) let's say we put on pause our test  for 20 seconds.
Even though element was available after 3 seconds, still your script will be on hold for 20 seconds.
We are increasing execution time, thus we are loosing money.
ImplicitWait - will help to wait for appearance of element, within given time-frame.
let's say you specified implicit wait time for 10 seconds, and If element was found faster,
 let's say in 2 seconds, your test will continue running and will not wait for extra 8 seconds.
 If after 10 seconds, element was not found, you will get NoSuchElementException.
ImplicitWait should be specified only once, at the beginning.
It will apply automatically before every findElement() method call, but not findElements()
Thread.sleep(10000) ---> always and only 10 seconds wait
implicitWait(10, TimeUnits.SECONDS) --> UP TO 10 seconds
next is Explicit Wait ---> It works in similar way as an implicit wait,
but explicit wait targets specific element with a specific condition.
Implicit resolves only one problem: presence of element.
Explicit wait resolves more problems:  presence of element, visibility,
 clickability, staleness of element, etc...
Every 500 milliseconds selenium will check if condition is met. If no,
it will keep checking withing given time frame.
wait until page is loaded handled automatically by selenium,
 but other conditions - no (like visibility or clickability).
Page is fully loaded, but element can delay, or be invisible, or not intractable.
***Element can be visible but not clickable. And implicit wait will not help you with this problem.
 THat's why we can use explicit wait.
####Fluent wait - it work like explicit wait, but except one difference -
you can change polling time. Explicit wait checks condition every 500 milliseconds.
 With a fluent wait, you can change this polling time.
 I would say that Fluent wait it's like custom explicit wait.

     */
}
