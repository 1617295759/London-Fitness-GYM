# London-Fitness-GYM
software enginerring group project 67

## Table of Contents

- [Background](#background)
- [Install](#install)
- [Usage](#usage)
	- [Generator](#generator)
- [Changelog](#changelog)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Background

“London Fitness” is a small gym operating in London. It used to be very busy, however, 
the pandemic has forced it to close. They can no longer provide onsite classes, personal 
training, clubs and they have to freeze the membership scheme. Even if it’s allowed to reopen later this year, it will have to adapt to the new normal as people will keep social 
distancing and will be cautioned to join classes. To keep the business running, the gym 
has to shift the focus from physical spaces towards virtual spaces. A digital gym system 
is urgently needed to allow gym members doing workouts at home.

## Install

This project uses [javafx](https://openjfx.io/) and [maven](http://maven.apache.org/download.cgi). Go check them out if you don't have them locally installed.

```sh
$ npm install --global standard-readme-spec
```

## Usage

This is only a documentation package. You can print out [spec.md](spec.md) to your console:

```sh
$ standard-readme-spec
# Prints out the standard-readme spec
```

### Generator

To use the generator, look at [generator-standard-readme](https://github.com/RichardLitt/generator-standard-readme). There is a global executable to run the generator in that package, aliased as `standard-readme`.

## Changelog

v1(29 March—9 April)
	Implement the log in verification.  CustomerDaoImpl has a lot of redundant code in the multiple methods. It is also simpler to convert the commonly used variables into member variables and initialize them in the constructor. The rest of the DAO layer recommendations follow this approach

v2(12 April — 25 April)
	Add two JavaBeans, Course and Video, and aggregate the Course collection into the Customer and Trainer classes. The CustomerDaoImpl constructor is not rigorous enough and has been modified. Add customer deleting function. Improve TrainerDaoImpl and other implementation. Add VideoWrapper. Add .idea to gitignore. Prevent to commit the .idea/ directory into git. To achieve video playback function, see TestVideo. Java for specific call. 

v3(26 April—9 May)
	Implement TrainerSchedule page presentation course. Show Coach Information. User registration and information verification function. Improve the front-end page.
	
v4(10 May-21 May)
	Merge remote-tracking branch 'origin/master' into master. Merge new front end.

## Maintainers

[@Jingbo Yang](https://github.com/Irene20000217).

## Contributing

You can see our contribution [here](https://github.com/1617295759/London-Fitness-GYM/graphs/contributors)
### Contributors
This project exists thanks to all the members of group 67.  
[@Yuzhang Wang](https://github.com/1617295759)  
[@Haoguang Wang](https://github.com/guapiguang)  
[@Jingbo Yang](https://github.com/Irene20000217)  
[@Jiahui Yu](https://github.com/simonsheng1999)  
[@Nan Shu](https://github.com/xuan-xuan7)  
[@Yue Ding](https://github.com/Lenient0104)



## License

[MIT](LICENSE) © Jingbo Yang

