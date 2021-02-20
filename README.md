# Five Days Forecast App

The application is written in Kotlin.
Download data from API and display them in the form of a list, forecast time and max. temperature.
The application uses the Retrofit library to communicate with the API.

I started building the MVVM architecture to make the application testable.

I think it will make a good impression on the user:
- good, intuitive UI
- data caching so that weather information is also available offline
- access to a large amount of weather information

# Left to do

1) full MVVM architecture (currently it is only ViewModel that is watched by view)
- repository
- DAO
- data base, may be Room

2) Handling any errors and exceptions, no access to system services (no internet access),
errors with API connection, etc.

3) Unit testing of non-views layers.

4) Division of the view into Fragments, e.g.
- MasterFragment - with a list of forecast periods
- DetailFragment - with a single forecast view

5) Library implementation for dependency injection (Koin, Kodein or Hilt)

6) Extracting resources to separate xml files (colors, strings, styles)

7) Separate views for smartphones and tablets also can be added.

# Testing
To test the application, just run it on an emulator or a physical device. You can also use, for example, the SauceLabs website.