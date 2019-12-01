create table "booking" (
    "booking_id" varchar(255) default random_uuid() not null,
    "asap" boolean,
    "created_on" timestamp,
    "last_modified_on" timestamp,
    "no_of_passengers" integer,
    "passenger_contact_number" varchar(255),
    "passenger_name" varchar(255),
    "pickup_time" timestamp,
    "price" decimal(19,2),
    "rating" integer,
    "waiting_time" integer,
    "deleted" boolean default false,
    primary key ("booking_id"));

create table "trip_waypoint" (
    "trip_way_point_id" varchar(255) default random_uuid() not null,
    "last_stop" boolean,
    "lat" double,
    "lng" double,
    "locality" varchar(255),
    "trip_way_point_timestamp" timestamp,
    "booking" varchar(255),
    "deleted" boolean default false,
    foreign key ("booking") references "booking"("booking_id"),
    primary key ("trip_way_point_id"));

create table "booking_waypoints" (
    "booking_id" varchar(255) not null,
    "trip_way_point_id" varchar(255) not null,
    foreign key ("booking_id") references "booking"("booking_id") on DELETE cascade on UPDATE cascade ,
    foreign key ("trip_way_point_id") references "trip_waypoint"("trip_way_point_id"));