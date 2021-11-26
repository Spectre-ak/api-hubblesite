# Hubblesite Images and Videos API


| URL | JSON Response |
| --- | --- |
| [https://hubblesite.azurewebsites.net/all/images](https://hubblesite.azurewebsites.net/all/images) | Returns list of all images |
| [https://hubblesite.azurewebsites.net/all/videos](https://hubblesite.azurewebsites.net/all/videos) | Returns list of all videos |
| [https://hubblesite.azurewebsites.net/images/tags/<tags>](https://hubblesite.azurewebsites.net/images/tags/<tags>) | Returns list of all images which contains provided tags |
| [https://hubblesite.azurewebsites.net/videos/tags/<tags>](https://hubblesite.azurewebsites.net/videos/tags/<tags>) | Returns list of all videos which contains provided tags |


  
### Sample response
  
  #### Videos
  
  https://hubblesite.azurewebsites.net/videos/tags/moon
  
  ```
  [
   {
      "date":"Release Date: October 03, 2018 2:00PM (EDT)",
      "title":"Possible Moon Outside Our Solar System (Artist's Interpretation)",
      "videoLinks":[
         [
            "https://stsci-opo.org/STScI-01EVS3KMJKQFTP4W4YJKKGKN2H.mp4",
            "1920 X 1080, 30 FPS, MP4 (6.26 MB)"
         ],
         [
            "https://stsci-opo.org/STScI-01EVS3KN48GV0TXRMZ10SJPYYV.mp4",
            "1920 X 1080, 30 FPS, MP4 (6.26 MB)"
         ],
         [
            "https://stsci-opo.org/STScI-01EVS3KNRNKE9XTMJCR7K1SQ9S.mp4",
            "640 X 360, 30 FPS, MP4 (11.84 MB)"
         ]
      ],
      "tags":[
         "Exomoons",
         "Exoplanets",
         "Kepler"
      ],
      "info":"This is an artist's interpretation of the gas giant planet Kepler-1625b and a suspected accompanying moon. Estimated to be as big as the planet Neptune, the moon is unlike anything found inside our solar system. The planet and moon orbit the Sun-like star Kepler-1625, located 8,000 light-years away in the constellation Cygnus. NASA's Hubble and Kepler space telescopes uncovered tantalizing evidence for the moon's existence, but further confirming observations are needed. Hubble couldn\u2019t photograph the moon because it is too far away. But its presence was deduced by watching how the moon blocks a little light from the star when it passes in front of it. Credits:NASA, ESA, and L. Hustak (STScI)"
   }, ...
]
  ```
  
  #### Images
  
  https://hubblesite.azurewebsites.net/images/tags/moon
  
  
  ```
  [
   {
      "date":"Release Date: July 26, 2021 11:00AM (EDT)",
      "title":"Hubble's View of Ganymede in 1996",
      "imgWithRes":[
         [
            "https://stsci-opo.org/STScI-01FAK39TV2FP144THY7C1822Y0.png",
            " 1200 X 1200"
         ]
      ],
      "tags":[
         "Moons"
      ],
      "info":"This image presents Jupiter's moon Ganymede as seen by NASA's Hubble Space Telescope in 1996. Located 1/2- billion miles (over 600 million kilometers) away, Hubble can follow changes on the moon and reveal other characteristics at ultraviolet and near-infrared wavelengths. Astronomers have now used new and archival datasets from Hubble to reveal evidence of water vapor in the atmosphere of Jupiter's moon Ganymede for the first time, which is present due to the thermal escape of water vapor from the moon's icy surface. Credits: SCIENCE: NASA, ESA, John Spencer (SwRI Boulder)"
   }, ...
]
  ```
