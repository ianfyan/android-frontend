# **anANTara** android application

The main purpose of this android application is only for administration stuff thus only admins that can login to this application

## Feature(s)

These are features that already/will be available in the application :

1. (C)reate (R)ead (U)pdate (D)elete Admins (only for admin with highest priviledge)
2. (C)reate (R)ead (U)pdate (D)elete Bansos (Bantuan Sosial)
3. (C)reate (R)ead (U)pdate (D)elete Location
4. (C)reate (R)ead (U)pdate (D)elete Recipient (Data Penerima Bansos)
5. Look at transaction in each vending machine in realtime
6. Graph for the data statistic (currently just showing the amount of available data)
7. Map to see location of each vending machine

## Development

### Tech Stack

- Currently need Android Studio version 4.2 and up to be able to build this project
- We are using `retrofit2` to make http request to the REST API (this will later be converted to using graphql client) 

### How to Contribute

These are steps that need to be done for development :
- Fork this repository
- Create issue in this repository about what problem you want to fix / what feature you want to add
- Start the development in your own repository by first creating branch that are unique to the development (problem to fix / feature to add)
- Open pull request to this repository and ask maintainer (anantara-android-team) that consist of [@fyan](https://github.com/ianfyan) and [@alif](https://github.com/alifsiregar) to review the PR
- Wait for the review approval and merge if approved

## Deployment

This application not yet been deployed to the playstore and currently just releasing apk through this repository releases
