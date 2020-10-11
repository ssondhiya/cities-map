# cities-map
Application which determines if two cities are connected. Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.

List of roads is available in a file called city.txt in resource folder. The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

It will be deployed as a Spring Boot App and expose one endpoint: http://localhost:8080/connected?origin=city1&destination=city2

It respond with 'yes' if city1 is connected to city2, 'no' if city1 is not connected to city2. Any unexpected input should result in a 'no response.
