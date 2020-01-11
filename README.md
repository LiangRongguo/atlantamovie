[![By RONGGUO_LIANG](https://img.shields.io/badge/by-RONGGUOLIANG-blue.svg)](https://github.com/LiangRongguo) [![Licence](https://img.shields.io/badge/license-GPL--3.0-blue.svg)](https://github.com/LiangRongguo/6242/blob/master/LICENSE) [![GitHub issues](https://img.shields.io/github/issues/LiangRongguo/atlantamovie.svg)](https://github.com/LiangRongguo/atlantamovie/issues/) [![GitHub Stars](https://img.shields.io/github/stars/LiangRongguo/atlantamovie.svg?style=social&label=Star)](https://github.com/LiangRongguo/atlantamovie)[![GitHub Forks](https://img.shields.io/github/forks/LiangRongguo/atlantamovie.svg?style=social&label=Fork)](https://github.com/LiangRongguo/atlantamovie)


#  Movie Theater Management System

 
![title_logo](img/title_log.png)


## Project <"Movie Theater Databse Management System"> V1

The project is aimed to build a theater database management system to improve the management and manipulation for users, administrators, customers, managers and cross-identity users.

It is also an academic study project of full-stack system development, conducted by Rongguo Liang.  

The design and structure for the database comes from CS4400 "Database System", instructed by Mark Moss, from Georgia Institute of Technology.

## Authors

* **Rongguo Liang**

## Documentations

Direct to project wiki page to download progress documentations in PDF. 

- [Project Wiki](https://github.com/LiangRongguo/atlantamovie/wiki)
 
- Project Hightlights:
 
 ![image1](https://github.com/MUYANGGUO/6242/blob/master/readme_images/image1.png)
 ![image2](https://github.com/MUYANGGUO/6242/blob/master/readme_images/image2.png)
 ![image3](https://github.com/MUYANGGUO/6242/blob/master/readme_images/image3.png)

## Datasets

- [Uber Movements](https://movement.uber.com/cities?lang=en-US)

- [Yelp Open Dataset](https://www.yelp.com/dataset)

- [Zillow Dataset](https://www.zillow.com/howto/api/APIOverview.htm)

- [SFPD Historical Crime Data](https://data.sfgov.org/Public-Safety/Police-Department-Incident-Reports-2018-to-Present/wg3w-h783)

## Visulization

- HTML,CSS, JS

- [Deck.gl](https://deck.gl/#/)

> All deck.gl layers are made to allow zoom, pan, rotate, focus. 
> All Props are made to be clickable/hoverable for different interactive purpose or exploratory data stats display.
 
  - Base Map Layer, mapbox tiles layer
  - Cleaned and reformatted Zillow geoJSON data as base layer, as subregions partitions
  - Systematically Sampled Uber Movements Trips Data, scaled to street level with color scheme for speed.
  - Icon Layers:
    - Red Icons : Hosts/Landlords, location as host location
    - Green Icons: Visitors/Tenants, location as destination location
    - Blue Icons: User "My Location"
  - Profile images layers, showing up with Icon Layers, display the users profile avatar image.
  - SFPD safety 3D extruded hexagon layers, show selected props surrounding incidents history since 2019, projected to hexagons and sort, rank by occurences for each sub hexagon. Extruded height is the incident density, with color scheme. 
    - on Hover: show the stats.
  - Yelp location icon layers, display selected props surrounding POIs, based on the keyword inputs, showing up in black to red linearly scaled color, color indicating the ratings. 
    - on Hover: show the yelp essential infos.

## Map Service

- [Mapbox](http://mapbox.com/)

## Contributing

> Please kindly refer to project wiki for details, for enviroment setup and account authroization, please see the link below:

- For web-builders,

[New contributor to the project directly please request for a authorization to the firebase project](https://github.com/MUYANGGUO/6242/wiki/Web-APP-Development-Environment-Setup-Guide)

- For non web-builders, please kindly star and fork this project.

- We are maintaining this project, and the API keys are rotated frequently.

## License

This project is licensed under the GPL_3.0 License - see the [LICENSE.md](/LICENSE) file for details

## Acknowledgments

To be updated...

## Demo
[V1 Demo](https://www.youtube.com/)

