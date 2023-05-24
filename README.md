# Sherlock and the Valid String

**Source** : https://www.hackerrank.com/challenges/sherlock-and-valid-string (reworked to return boolean values instead of strings)

Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just `1` character at `1` index in the string, and the remaining characters will occur the same number of times. Given a string, determine if it is valid. If so, return true, otherwise return false.

For example, if `s = abc`, it is a valid string because frequencies are `{a : 1, b : 1, c : 1}`. So is `s = abcc` because we can remove one `c` and have `1` of each character in the remaining string. If `s = abccc` however, the string is not valid as we can only remove `1` occurrence of `c`. That would leave character frequencies of `{a : 1, b : 1, c: 2}`.

## Function Description

Complete the isValid function in the editor below. It should return either the boolean value true or the boolean value false.

isValid has the following parameter(s):

- s: a string

## Input Format

A single string s.

## Constraints

- 1 <= length of `s` <= 10^5
 
## Output Format

Returns `true` if string is valid, otherwise, returns `false`.

## Sample Input 0

    aabbcd
    
## Sample Output 0

    false

## Explanation 0

Given `s = "aabbcd"`, we would need to remove two characters, both `c` and `d` -> `aabb` or `a` and `b` -> `abcd`, to make it valid. We are limited to removing only one character, so `s` is invalid.

## Sample Input 1

    aabbccddeefghi

## Sample Output 1

    false
    
## Explanation 1

Frequency counts for the letters are as follows:

`{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}`

There are two ways to make the valid string:

- Remove 4 characters with a frequency of `1 : {fghi}`.
- Remove 5 characters of frequency `2 : {abcde}`.

Neither of these is an option.

## Sample Input 2

    abcdefghhgfedecba

## Sample Output 2

    true

## Explanation 2

All characters occur twice except for `e` which occurs `3` times. We can delete one instance of `e` to have a valid string.



