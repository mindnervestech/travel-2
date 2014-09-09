# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table allottment_market (
  id                        bigint auto_increment not null,
  yield_mgmt_model_id       bigint not null,
  is_apply_to_rates         varchar(255),
  is_specify_allotment      varchar(255),
  is_free_sell              varchar(255),
  is_stop_sell_on_req       varchar(255),
  is_apply_to_all_markets   varchar(255),
  is_apply_to_all_markets_occupancy varchar(255),
  is_free_sell_occ_adult1   varchar(255),
  is_stop_sell_on_req_adult1 varchar(255),
  is_free_sell_occ_adult2   varchar(255),
  is_stop_sell_on_req_adult2 varchar(255),
  is_free_sell_occ_adult3   varchar(255),
  is_stop_sell_on_req_adult3 varchar(255),
  release_period1           varchar(255),
  release_period2           varchar(255),
  release_period3           varchar(255),
  release_period4           varchar(255),
  cutoff_occupancy1         varchar(255),
  cutoff_occupancy2         varchar(255),
  cutoff_occupancy3         varchar(255),
  allotment_market_rates_with_commas varchar(255),
  apply_to_all_markets_with_commas varchar(255),
  apply_to_all_markets_occupancy_with_commas varchar(255),
  constraint pk_allottment_market primary key (id))
;

create table area_attraction_model (
  id                        bigint auto_increment not null,
  area_name1                varchar(255),
  area_distance1            varchar(255),
  area_minutes1             varchar(255),
  area_parameter1           varchar(255),
  area_name2                varchar(255),
  area_distance2            varchar(255),
  area_minutes2             varchar(255),
  area_parameter2           varchar(255),
  area_name3                varchar(255),
  area_distance3            varchar(255),
  area_minutes3             varchar(255),
  area_parameter3           varchar(255),
  area_name4                varchar(255),
  area_distance4            varchar(255),
  area_minutes4             varchar(255),
  area_parameter4           varchar(255),
  area_name5                varchar(255),
  area_distance5            varchar(255),
  area_minutes5             varchar(255),
  area_parameter5           varchar(255),
  area_name6                varchar(255),
  area_distance6            varchar(255),
  area_minutes6             varchar(255),
  area_parameter6           varchar(255),
  area_name7                varchar(255),
  area_distance7            varchar(255),
  area_minutes7             varchar(255),
  area_parameter7           varchar(255),
  area_name8                varchar(255),
  area_distance8            varchar(255),
  area_minutes8             varchar(255),
  area_parameter8           varchar(255),
  area_name9                varchar(255),
  area_distance9            varchar(255),
  area_minutes9             varchar(255),
  area_parameter9           varchar(255),
  area_name10               varchar(255),
  area_distance10           varchar(255),
  area_minutes10            varchar(255),
  area_parameter10          varchar(255),
  supplier_object_id        bigint,
  constraint pk_area_attraction_model primary key (id))
;

create table business_communication_model (
  id                        bigint auto_increment not null,
  communication_email       varchar(255),
  re_communication_email    varchar(255),
  communication_email_cc    varchar(255),
  re_communication_email_cc varchar(255),
  is_ccrequired             varchar(255),
  supplier_object_id        bigint,
  constraint pk_business_communication_model primary key (id))
;

create table cctvstatus (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_cctvstatus_code unique (code),
  constraint pk_cctvstatus primary key (id))
;

create table cancellation_section (
  id                        bigint auto_increment not null,
  repeat_rate_sections_id   bigint not null,
  cancellation_time         varchar(255),
  penalty_charge            varchar(255),
  nights                    varchar(255),
  percentages               varchar(255),
  constraint pk_cancellation_section primary key (id))
;

create table cancellation_section1 (
  id                        bigint auto_increment not null,
  repeat_rate_sections_id   bigint not null,
  cancellation_time1        varchar(255),
  penalty_charge1           varchar(255),
  nights1                   varchar(255),
  percentages1              varchar(255),
  constraint pk_cancellation_section1 primary key (id))
;

create table country (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_country_code unique (code),
  constraint pk_country primary key (id))
;

create table currency (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_currency_code unique (code),
  constraint pk_currency primary key (id))
;

create table day (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_day_code unique (code),
  constraint pk_day primary key (id))
;

create table hotel_additional_information (
  id                        bigint auto_increment not null,
  room_tax                  varchar(255),
  currency_mandatory        varchar(255),
  is_mandatory_charges      varchar(255),
  surcharge_per_room        varchar(255),
  surcharge_per_room_perctntage varchar(255),
  tariff_notes              varchar(255),
  is_mandatory_transfers    varchar(255),
  guest_age_validity        varchar(255),
  check_in_time             varchar(255),
  check_out_time            varchar(255),
  is_mandatory_supplement   varchar(255),
  tax_container             varchar(255),
  additioanl_m              varchar(255),
  supplement_period         varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_additional_information primary key (id))
;

create table hotel_additional_mandatory_info (
  id                        bigint auto_increment not null,
  is_additional_mandatory_service varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_additional_mandatory_info primary key (id))
;

create table hotel_amenities (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_amenities_code unique (code),
  constraint pk_hotel_amenities primary key (id))
;

create table hotel_amenities_model (
  id                        bigint auto_increment not null,
  hotel_amenities_with_commas varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_amenities_model primary key (id))
;

create table hotel_billing_information_model (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  accounting_cntct_first_name varchar(255),
  accounting_cntct_last_name varchar(255),
  accounting_cntct_title    varchar(255),
  accounting_cntct_email    varchar(255),
  accounting_cntct_tel_code varchar(255),
  accounting_cntct_tel_number varchar(255),
  accounting_cntct_fax_code varchar(255),
  accounting_cntct_fax_number varchar(255),
  accounting_cntct_ext      varchar(255),
  is_invoices_will_go       varchar(255),
  is_wire_service           varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_billing_information_model primary key (id))
;

create table hotel_business_amenities (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_business_amenities_code unique (code),
  constraint pk_hotel_business_amenities primary key (id))
;

create table hotel_business_amenities_model (
  id                        bigint auto_increment not null,
  hotel_business_amenities_with_commas varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_business_amenities_model primary key (id))
;

create table hotel_chain (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_chain_code unique (code),
  constraint pk_hotel_chain primary key (id))
;

create table hotel_contact_information_model (
  id                        bigint auto_increment not null,
  main_contact_name         varchar(255),
  title                     varchar(255),
  direct_tel_code           varchar(255),
  direct_tel_number         varchar(255),
  direct_fax_code           varchar(255),
  direct_fax_number         varchar(255),
  extension                 varchar(255),
  direct_email              varchar(255),
  toll_free_code            varchar(255),
  toll_free_number          varchar(255),
  reservation_contact_name  varchar(255),
  reservationtitle          varchar(255),
  reservation_direct_tel_code varchar(255),
  reservation_direct_tel_number varchar(255),
  reservation_direct_email  varchar(255),
  reservation_extension     varchar(255),
  reservation_dept_direct_tel_code varchar(255),
  reservation_dept_direct_tel_number varchar(255),
  reservation_dept_fax_code varchar(255),
  reservation_dept_fax_number varchar(255),
  reservation_dept_extension varchar(255),
  salutation                varchar(255),
  is_same_address           varchar(255),
  fax_recieve               varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_contact_information_model primary key (id))
;

create table hotel_description_modal (
  id                        bigint auto_increment not null,
  profile_description       varchar(255),
  location_area             varchar(255),
  shopping_facility         varchar(255),
  night_life                varchar(255),
  hotel_description_option_with_commas varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_description_modal primary key (id))
;

create table hotel_description_options (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_description_options_code unique (code),
  constraint pk_hotel_description_options primary key (id))
;

create table hotel_health_safety_model (
  id                        bigint auto_increment not null,
  is_documetation_public_liability varchar(255),
  documetation_public_liability_expiry_date varchar(255),
  is_documetation_fire_assesment varchar(255),
  documetation_fire_assesment_expiry_date varchar(255),
  is_documetation_authority_license varchar(255),
  is_documetation_internal_fire_alarm varchar(255),
  is_documetation_haccp     varchar(255),
  is_documetation_staff_training_for_fire varchar(255),
  is_documetation_staff_training_for_health varchar(255),
  is_fire_precaution_working_alarm varchar(255),
  is_fire_precaution_smoke_detectorin_public_area varchar(255),
  is_fire_precaution_smoke_detectorin_guest_room varchar(255),
  is_fire_precaution_smoke_detectorin_appartment varchar(255),
  is_fire_precaution_service_annually varchar(255),
  is_fire_precaution_internal_fire_alarm_test varchar(255),
  is_fire_precaution_extinguisherin_public_area varchar(255),
  is_fire_precaution_emergency_lighting varchar(255),
  is_fire_precaution_for_pwd varchar(255),
  no_of_exits               varchar(255),
  is_exit_unlocked          varchar(255),
  is_exit_clearly_signed    varchar(255),
  is_exit_routes_illuminated varchar(255),
  is_exit_more_staircase    varchar(255),
  is_accentral              varchar(255),
  is_acindependent          varchar(255),
  is_lift_all_floor         varchar(255),
  is_lift_internal_closing_door varchar(255),
  is_lift_relevant_sign     varchar(255),
  is_lift_no_smoking        varchar(255),
  is_lift_no_unaccompanied_children varchar(255),
  is_lift_event_of_fire     varchar(255),
  is_bed_room_fire_safety_instruction varchar(255),
  is_bed_room_electric_disconnect varchar(255),
  is_bed_room_balcony       varchar(255),
  is_bed_room_balcony_height varchar(255),
  is_bed_room_balcony_gaps  varchar(255),
  is_bed_room_adjoining_rooms varchar(255),
  adjoining_rooms_number    varchar(255),
  is_kitchen_self_catering  varchar(255),
  is_kitchen_regularly_serviced varchar(255),
  is_kitchen_self_catering_usage_instruction varchar(255),
  is_main_kitchen           varchar(255),
  is_kitchen_temperature_check varchar(255),
  is_kitchen_pests_proofed  varchar(255),
  is_child_internal_play_area varchar(255),
  is_child_external_play_area varchar(255),
  is_child_supervise        varchar(255),
  is_child_equipment_check  varchar(255),
  is_child_operational_months_with_commas varchar(255),
  is_swimming_rules         varchar(255),
  is_swimming_timing        varchar(255),
  is_swimming_depth         varchar(255),
  is_swimming_diving        varchar(255),
  is_swimming_unaccompanied_children varchar(255),
  is_swimming_life_guard_info varchar(255),
  is_swimming_no_glass      varchar(255),
  is_swimming_life_guard_at_opening_time varchar(255),
  is_children_pool          varchar(255),
  is_children_pool_seperated varchar(255),
  is_swimming_depth_marking varchar(255),
  is_swimming_pool_cleaned  varchar(255),
  is_swimming_pool_cleaned_records varchar(255),
  is_swimming_heated_pool   varchar(255),
  is_swimming_heated_pool_months_with_commas varchar(255),
  is_gas_heaters            varchar(255),
  is_internal_gas_heaters   varchar(255),
  is_external_gas_heaters   varchar(255),
  is_servicing_documentation varchar(255),
  is_maintainance_documentation varchar(255),
  cctv_status_with_commas   varchar(255),
  additional_information_commnets varchar(255),
  additional_information_name varchar(255),
  additional_information_designation varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_health_safety_model primary key (id))
;

create table hotel_image (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  image_bytes               longblob,
  supplier_id               bigint,
  constraint pk_hotel_image primary key (id))
;

create table hotel_internal_information_model (
  id                        bigint auto_increment not null,
  built_year                varchar(255),
  last_renovate_year        varchar(255),
  no_of_floors              varchar(255),
  no_of_rooms               varchar(255),
  guest_tel_city_code       varchar(255),
  guest_tel_city_number     varchar(255),
  guest_fax_city_code       varchar(255),
  guest_fax_city_number     varchar(255),
  hotel_website             varchar(255),
  hotel_email               varchar(255),
  direct_tel_city_code      varchar(255),
  direct_tel_city_number    varchar(255),
  direct_fax_city_code      varchar(255),
  direct_fax_city_number    varchar(255),
  general_manager_name      varchar(255),
  general_manager_email     varchar(255),
  is_safety_complaint       varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_internal_information_model primary key (id))
;

create table hotel_leisure_amenities (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_leisure_amenities_code unique (code),
  constraint pk_hotel_leisure_amenities primary key (id))
;

create table hotel_leisure_amenities_model (
  id                        bigint auto_increment not null,
  hotel_leisure_amenities_with_commas varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_leisure_amenities_model primary key (id))
;

create table hotel_location_area (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_hotel_location_area_code unique (code),
  constraint pk_hotel_location_area primary key (id))
;

create table hotel_location_model (
  id                        bigint auto_increment not null,
  hotel_location1           varchar(255),
  hotel_location2           varchar(255),
  hotel_location3           varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_location_model primary key (id))
;

create table hotel_transportation_model (
  id                        bigint auto_increment not null,
  airport_name1             varchar(255),
  airport_direction1        varchar(255),
  airport_distance1         varchar(255),
  airport_minutes1          varchar(255),
  airport_parameter1        varchar(255),
  airport_name2             varchar(255),
  airport_direction2        varchar(255),
  airport_distance2         varchar(255),
  airport_minutes2          varchar(255),
  airport_parameter2        varchar(255),
  rail_way_station_name1    varchar(255),
  rail_way_station_direction1 varchar(255),
  rail_way_station_distance1 varchar(255),
  rail_way_station_minutes1 varchar(255),
  rail_way_station_parameter1 varchar(255),
  rail_way_station_name2    varchar(255),
  rail_way_station_direction2 varchar(255),
  rail_way_station_distance2 varchar(255),
  rail_way_station_minutes2 varchar(255),
  rail_way_station_parameter2 varchar(255),
  subway_name1              varchar(255),
  subway_direction1         varchar(255),
  subway_distance1          varchar(255),
  subway_minutes1           varchar(255),
  subway_parameter1         varchar(255),
  subway_name2              varchar(255),
  subway_direction2         varchar(255),
  subway_distance2          varchar(255),
  subway_minutes2           varchar(255),
  subway_parameter2         varchar(255),
  cruise_port_name1         varchar(255),
  cruise_port_direction1    varchar(255),
  cruise_port_distance1     varchar(255),
  cruise_port_minutes1      varchar(255),
  cruise_port_parameter1    varchar(255),
  cruise_port_name2         varchar(255),
  cruise_port_direction2    varchar(255),
  cruise_port_distance2     varchar(255),
  cruise_port_minutes2      varchar(255),
  cruise_port_parameter2    varchar(255),
  supplier_object_id        bigint,
  constraint pk_hotel_transportation_model primary key (id))
;

create table market_rate_policy (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_market_rate_policy_code unique (code),
  constraint pk_market_rate_policy primary key (id))
;

create table meal_overlay_model (
  id                        bigint auto_increment not null,
  meal_from_date            varchar(255),
  meal_to_date              varchar(255),
  meal_type                 varchar(255),
  meal_name                 varchar(255),
  meal_adult_rate           varchar(255),
  is_adult_include_tax      varchar(255),
  meal_adult_tax            varchar(255),
  meal_adult_tax_percent    varchar(255),
  meal_adult_discount       varchar(255),
  meal_adult_discount_percent varchar(255),
  supplier_object_id        bigint,
  constraint pk_meal_overlay_model primary key (id))
;

create table months (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_months_code unique (code),
  constraint pk_months primary key (id))
;

create table night_life (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_night_life_code unique (code),
  constraint pk_night_life primary key (id))
;

create table profie_general_information_model (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  property_name             varchar(255),
  name                      varchar(255),
  address                   varchar(255),
  country                   varchar(255),
  province                  varchar(255),
  city                      varchar(255),
  pin                       varchar(255),
  rating                    varchar(255),
  password                  varchar(255),
  market_rate_policy        varchar(255),
  is_chain                  varchar(255),
  is_health_complaint       varchar(255),
  affiliated_chain          varchar(255),
  currency                  varchar(255),
  supplier_object_id        bigint,
  constraint pk_profie_general_information_model primary key (id))
;

create table province (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  country_id                bigint,
  constraint uq_province_code unique (code),
  constraint pk_province primary key (id))
;

create table repeat_child_meal_rate_sections (
  id                        bigint auto_increment not null,
  meal_overlay_model_id     bigint not null,
  child_from_age            varchar(255),
  child_to_age              varchar(255),
  meal_child_rate           varchar(255),
  is_child_include_tax      varchar(255),
  meal_child_tax            varchar(255),
  meal_child_tax_percent    varchar(255),
  meal_child_discount       varchar(255),
  meal_child_discount_percent varchar(255),
  constraint pk_repeat_child_meal_rate_sections primary key (id))
;

create table repeat_mandatory_sections (
  id                        bigint auto_increment not null,
  hotel_additional_mandatory_info_id bigint not null,
  additional_mandatory_service_name varchar(255),
  additional_mandatory_service_validity_from varchar(255),
  additional_mandatory_service_validity_to varchar(255),
  additional_mandatory_service_is_apply varchar(255),
  additional_mandatory_serviceis_checkin varchar(255),
  additional_mandatory_service_per_room_rate varchar(255),
  additional_mandatory_service_per_person_adult_rate varchar(255),
  additional_mandatory_service_per_person_child_rate varchar(255),
  is_related_info           varchar(255),
  is_related_selection      varchar(255),
  related_selection_info    varchar(255),
  multiple_selection_answer_choice1 varchar(255),
  multiple_selection_answer_choice2 varchar(255),
  multiple_selection_answer_choice3 varchar(255),
  multiple_selection_answer_choice4 varchar(255),
  radio_selection_answer_option_yes varchar(255),
  radio_selection_answer_option_no varchar(255),
  constraint pk_repeat_mandatory_sections primary key (id))
;

create table repeat_mandatory_sections1 (
  id                        bigint auto_increment not null,
  repeat_mandatory_sections_id bigint not null,
  is_related_selection      varchar(255),
  multiple_selection_answer_choice1 varchar(255),
  multiple_selection_answer_choice2 varchar(255),
  multiple_selection_answer_choice3 varchar(255),
  multiple_selection_answer_choice4 varchar(255),
  radio_selection_answer_option_yes varchar(255),
  radio_selection_answer_option_no varchar(255),
  related_selection_info    varchar(255),
  constraint pk_repeat_mandatory_sections1 primary key (id))
;

create table repeat_rate_sections (
  id                        bigint auto_increment not null,
  yield_mgmt_model_id       bigint not null,
  general_rate_adult1       varchar(255),
  general_rate_adult2       varchar(255),
  general_rate_adult3       varchar(255),
  general_rate_adult_include1 varchar(255),
  general_rate_adult_include2 varchar(255),
  general_rate_adult_include3 varchar(255),
  general_adult_rate_basis1 varchar(255),
  general_adult_rate_basis2 varchar(255),
  general_adult_rate_basis3 varchar(255),
  general_adult_rate_type1  varchar(255),
  general_adult_rate_type2  varchar(255),
  general_adult_rate_type3  varchar(255),
  different_net_rates       varchar(255),
  different_rate_adult1     varchar(255),
  different_rate_adult2     varchar(255),
  different_rate_adult3     varchar(255),
  different_rate_adult_include1 varchar(255),
  different_rate_adult_include2 varchar(255),
  different_rate_adult_include3 varchar(255),
  different_adult_rate_basis1 varchar(255),
  different_adult_rate_basis2 varchar(255),
  different_adult_rate_basis3 varchar(255),
  different_adult_rate_type1 varchar(255),
  different_adult_rate_type2 varchar(255),
  different_adult_rate_type3 varchar(255),
  is_passenger_nationality  varchar(255),
  no_of_min_nights          varchar(255),
  minimum_stay_days_with_commas varchar(255),
  applicable_days_with_commas varchar(255),
  rate_market_type_with_commas varchar(255),
  constraint pk_repeat_rate_sections primary key (id))
;

create table repeat_supplement_sections (
  id                        bigint auto_increment not null,
  hotel_additional_information_id bigint not null,
  supplement_from_month     varchar(255),
  supplement_to_month       varchar(255),
  supplement_from_day       varchar(255),
  supplement_to_day         varchar(255),
  supplement_from_year      varchar(255),
  supplement_to_year        varchar(255),
  supplement_name           varchar(255),
  supplement_description    varchar(255),
  is_apply                  varchar(255),
  supplement_per_room_rate  varchar(255),
  is_per_room_rate          varchar(255),
  per_room_rate_tax         varchar(255),
  per_room_rate_tax_percent varchar(255),
  per_room_rate_discount    varchar(255),
  per_room_rate_discount_percent varchar(255),
  supplement_per_person_adult_rate varchar(255),
  supplement_per_person_child_rate varchar(255),
  is_per_person_adult_rate  varchar(255),
  is_per_person_child_rate  varchar(255),
  per_person_adult_rate_tax varchar(255),
  per_person_adult_rate_tax_percent varchar(255),
  per_person_adult_rate_discount varchar(255),
  per_person_adult_rate_discount_percent varchar(255),
  per_person_child_rate_tax varchar(255),
  per_person_child_rate_tax_percent varchar(255),
  per_person_child_rate_discount varchar(255),
  per_person_child_rate_discount_percent varchar(255),
  constraint pk_repeat_supplement_sections primary key (id))
;

create table repeat_tax_sections (
  id                        bigint auto_increment not null,
  hotel_additional_information_id bigint not null,
  tax_period_from           varchar(255),
  tax_period_to             varchar(255),
  tax_name                  varchar(255),
  tax_amount                varchar(255),
  tax_is                    varchar(255),
  currency                  varchar(255),
  taxcurrency1              varchar(255),
  constraint pk_repeat_tax_sections primary key (id))
;

create table room_amenity (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_room_amenity_code unique (code),
  constraint pk_room_amenity primary key (id))
;

create table room_type_model (
  id                        bigint auto_increment not null,
  room_name                 varchar(255),
  max_occupancy             varchar(255),
  max_adult_occupancy       varchar(255),
  max_adult_child_occupancy varchar(255),
  is_twin_beds              varchar(255),
  child_sharing_with_adult  varchar(255),
  is_child_chargeable       varchar(255),
  is_extra_bed              varchar(255),
  is_extra_bed_charge       varchar(255),
  extra_bed_amount          varchar(255),
  net_rate                  varchar(255),
  is_room_suite             varchar(255),
  room_amenities_with_commas varchar(255),
  supplier_object_id        bigint,
  constraint pk_room_type_model primary key (id))
;

create table salutation (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_salutation_code unique (code),
  constraint pk_salutation primary key (id))
;

create table shopping_facility (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_shopping_facility_code unique (code),
  constraint pk_shopping_facility primary key (id))
;

create table supplier (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  supplier_status           varchar(255),
  area_attraction_model_id  bigint,
  business_communication_model_id bigint,
  hotel_amenities_model_id  bigint,
  hotel_additional_information_id bigint,
  hotel_additional_mandatory_info_id bigint,
  billing_information_model_id bigint,
  hotel_business_amenities_model_id bigint,
  hotel_contact_information_model_id bigint,
  description_modal_id      bigint,
  hotel_health_safety_model_id bigint,
  hotel_internal_information_model_id bigint,
  hotel_leisure_amenities_model_id bigint,
  hotel_location_model_id   bigint,
  hotel_transportation_model_id bigint,
  general_information_id    bigint,
  meal_overlay_model_id     bigint,
  additional_information_id bigint,
  additional_mandatory_info_id bigint,
  constraint pk_supplier primary key (id))
;

create table supplier_code (
  id                        bigint auto_increment not null,
  code                      bigint,
  constraint pk_supplier_code primary key (id))
;

create table time (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_time_code unique (code),
  constraint pk_time primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  user_type                 varchar(255),
  supplier_object_id        bigint,
  constraint pk_user primary key (id))
;

create table year (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  name                      varchar(255),
  constraint uq_year_code unique (code),
  constraint pk_year primary key (id))
;

create table yield_mgmt_model (
  id                        bigint auto_increment not null,
  supplier_object_id        bigint,
  constraint pk_yield_mgmt_model primary key (id))
;

alter table allottment_market add constraint fk_allottment_market_yield_mgmt_model_1 foreign key (yield_mgmt_model_id) references yield_mgmt_model (id) on delete restrict on update restrict;
create index ix_allottment_market_yield_mgmt_model_1 on allottment_market (yield_mgmt_model_id);
alter table area_attraction_model add constraint fk_area_attraction_model_supplierObject_2 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_area_attraction_model_supplierObject_2 on area_attraction_model (supplier_object_id);
alter table business_communication_model add constraint fk_business_communication_model_supplierObject_3 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_business_communication_model_supplierObject_3 on business_communication_model (supplier_object_id);
alter table cancellation_section add constraint fk_cancellation_section_repeat_rate_sections_4 foreign key (repeat_rate_sections_id) references repeat_rate_sections (id) on delete restrict on update restrict;
create index ix_cancellation_section_repeat_rate_sections_4 on cancellation_section (repeat_rate_sections_id);
alter table cancellation_section1 add constraint fk_cancellation_section1_repeat_rate_sections_5 foreign key (repeat_rate_sections_id) references repeat_rate_sections (id) on delete restrict on update restrict;
create index ix_cancellation_section1_repeat_rate_sections_5 on cancellation_section1 (repeat_rate_sections_id);
alter table hotel_additional_information add constraint fk_hotel_additional_information_supplierObject_6 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_additional_information_supplierObject_6 on hotel_additional_information (supplier_object_id);
alter table hotel_additional_mandatory_info add constraint fk_hotel_additional_mandatory_info_supplierObject_7 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_additional_mandatory_info_supplierObject_7 on hotel_additional_mandatory_info (supplier_object_id);
alter table hotel_amenities_model add constraint fk_hotel_amenities_model_supplierObject_8 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_amenities_model_supplierObject_8 on hotel_amenities_model (supplier_object_id);
alter table hotel_billing_information_model add constraint fk_hotel_billing_information_model_supplierObject_9 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_billing_information_model_supplierObject_9 on hotel_billing_information_model (supplier_object_id);
alter table hotel_business_amenities_model add constraint fk_hotel_business_amenities_model_supplierObject_10 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_business_amenities_model_supplierObject_10 on hotel_business_amenities_model (supplier_object_id);
alter table hotel_contact_information_model add constraint fk_hotel_contact_information_model_supplierObject_11 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_contact_information_model_supplierObject_11 on hotel_contact_information_model (supplier_object_id);
alter table hotel_description_modal add constraint fk_hotel_description_modal_supplierObject_12 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_description_modal_supplierObject_12 on hotel_description_modal (supplier_object_id);
alter table hotel_health_safety_model add constraint fk_hotel_health_safety_model_supplierObject_13 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_health_safety_model_supplierObject_13 on hotel_health_safety_model (supplier_object_id);
alter table hotel_image add constraint fk_hotel_image_supplier_14 foreign key (supplier_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_image_supplier_14 on hotel_image (supplier_id);
alter table hotel_internal_information_model add constraint fk_hotel_internal_information_model_supplierObject_15 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_internal_information_model_supplierObject_15 on hotel_internal_information_model (supplier_object_id);
alter table hotel_leisure_amenities_model add constraint fk_hotel_leisure_amenities_model_supplierObject_16 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_leisure_amenities_model_supplierObject_16 on hotel_leisure_amenities_model (supplier_object_id);
alter table hotel_location_model add constraint fk_hotel_location_model_supplierObject_17 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_location_model_supplierObject_17 on hotel_location_model (supplier_object_id);
alter table hotel_transportation_model add constraint fk_hotel_transportation_model_supplierObject_18 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_hotel_transportation_model_supplierObject_18 on hotel_transportation_model (supplier_object_id);
alter table meal_overlay_model add constraint fk_meal_overlay_model_supplierObject_19 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_meal_overlay_model_supplierObject_19 on meal_overlay_model (supplier_object_id);
alter table profie_general_information_model add constraint fk_profie_general_information_model_supplierObject_20 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_profie_general_information_model_supplierObject_20 on profie_general_information_model (supplier_object_id);
alter table province add constraint fk_province_country_21 foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_province_country_21 on province (country_id);
alter table repeat_child_meal_rate_sections add constraint fk_repeat_child_meal_rate_sections_meal_overlay_model_22 foreign key (meal_overlay_model_id) references meal_overlay_model (id) on delete restrict on update restrict;
create index ix_repeat_child_meal_rate_sections_meal_overlay_model_22 on repeat_child_meal_rate_sections (meal_overlay_model_id);
alter table repeat_mandatory_sections add constraint fk_repeat_mandatory_sections_hotel_additional_mandatory_info_23 foreign key (hotel_additional_mandatory_info_id) references hotel_additional_mandatory_info (id) on delete restrict on update restrict;
create index ix_repeat_mandatory_sections_hotel_additional_mandatory_info_23 on repeat_mandatory_sections (hotel_additional_mandatory_info_id);
alter table repeat_mandatory_sections1 add constraint fk_repeat_mandatory_sections1_repeat_mandatory_sections_24 foreign key (repeat_mandatory_sections_id) references repeat_mandatory_sections (id) on delete restrict on update restrict;
create index ix_repeat_mandatory_sections1_repeat_mandatory_sections_24 on repeat_mandatory_sections1 (repeat_mandatory_sections_id);
alter table repeat_rate_sections add constraint fk_repeat_rate_sections_yield_mgmt_model_25 foreign key (yield_mgmt_model_id) references yield_mgmt_model (id) on delete restrict on update restrict;
create index ix_repeat_rate_sections_yield_mgmt_model_25 on repeat_rate_sections (yield_mgmt_model_id);
alter table repeat_supplement_sections add constraint fk_repeat_supplement_sections_hotel_additional_information_26 foreign key (hotel_additional_information_id) references hotel_additional_information (id) on delete restrict on update restrict;
create index ix_repeat_supplement_sections_hotel_additional_information_26 on repeat_supplement_sections (hotel_additional_information_id);
alter table repeat_tax_sections add constraint fk_repeat_tax_sections_hotel_additional_information_27 foreign key (hotel_additional_information_id) references hotel_additional_information (id) on delete restrict on update restrict;
create index ix_repeat_tax_sections_hotel_additional_information_27 on repeat_tax_sections (hotel_additional_information_id);
alter table room_type_model add constraint fk_room_type_model_supplierObject_28 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_room_type_model_supplierObject_28 on room_type_model (supplier_object_id);
alter table supplier add constraint fk_supplier_areaAttractionModel_29 foreign key (area_attraction_model_id) references area_attraction_model (id) on delete restrict on update restrict;
create index ix_supplier_areaAttractionModel_29 on supplier (area_attraction_model_id);
alter table supplier add constraint fk_supplier_businessCommunicationModel_30 foreign key (business_communication_model_id) references business_communication_model (id) on delete restrict on update restrict;
create index ix_supplier_businessCommunicationModel_30 on supplier (business_communication_model_id);
alter table supplier add constraint fk_supplier_hotelAmenitiesModel_31 foreign key (hotel_amenities_model_id) references hotel_amenities_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelAmenitiesModel_31 on supplier (hotel_amenities_model_id);
alter table supplier add constraint fk_supplier_hotelAdditionalInformation_32 foreign key (hotel_additional_information_id) references hotel_additional_information (id) on delete restrict on update restrict;
create index ix_supplier_hotelAdditionalInformation_32 on supplier (hotel_additional_information_id);
alter table supplier add constraint fk_supplier_hotelAdditionalMandatoryInfo_33 foreign key (hotel_additional_mandatory_info_id) references hotel_additional_mandatory_info (id) on delete restrict on update restrict;
create index ix_supplier_hotelAdditionalMandatoryInfo_33 on supplier (hotel_additional_mandatory_info_id);
alter table supplier add constraint fk_supplier_billingInformationModel_34 foreign key (billing_information_model_id) references hotel_billing_information_model (id) on delete restrict on update restrict;
create index ix_supplier_billingInformationModel_34 on supplier (billing_information_model_id);
alter table supplier add constraint fk_supplier_hotelBusinessAmenitiesModel_35 foreign key (hotel_business_amenities_model_id) references hotel_business_amenities_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelBusinessAmenitiesModel_35 on supplier (hotel_business_amenities_model_id);
alter table supplier add constraint fk_supplier_hotelContactInformationModel_36 foreign key (hotel_contact_information_model_id) references hotel_contact_information_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelContactInformationModel_36 on supplier (hotel_contact_information_model_id);
alter table supplier add constraint fk_supplier_descriptionModal_37 foreign key (description_modal_id) references hotel_description_modal (id) on delete restrict on update restrict;
create index ix_supplier_descriptionModal_37 on supplier (description_modal_id);
alter table supplier add constraint fk_supplier_hotelHealthSafetyModel_38 foreign key (hotel_health_safety_model_id) references hotel_health_safety_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelHealthSafetyModel_38 on supplier (hotel_health_safety_model_id);
alter table supplier add constraint fk_supplier_hotelInternalInformationModel_39 foreign key (hotel_internal_information_model_id) references hotel_internal_information_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelInternalInformationModel_39 on supplier (hotel_internal_information_model_id);
alter table supplier add constraint fk_supplier_hotelLeisureAmenitiesModel_40 foreign key (hotel_leisure_amenities_model_id) references hotel_leisure_amenities_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelLeisureAmenitiesModel_40 on supplier (hotel_leisure_amenities_model_id);
alter table supplier add constraint fk_supplier_hotelLocationModel_41 foreign key (hotel_location_model_id) references hotel_location_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelLocationModel_41 on supplier (hotel_location_model_id);
alter table supplier add constraint fk_supplier_hotelTransportationModel_42 foreign key (hotel_transportation_model_id) references hotel_transportation_model (id) on delete restrict on update restrict;
create index ix_supplier_hotelTransportationModel_42 on supplier (hotel_transportation_model_id);
alter table supplier add constraint fk_supplier_generalInformation_43 foreign key (general_information_id) references profie_general_information_model (id) on delete restrict on update restrict;
create index ix_supplier_generalInformation_43 on supplier (general_information_id);
alter table supplier add constraint fk_supplier_mealOverlayModel_44 foreign key (meal_overlay_model_id) references meal_overlay_model (id) on delete restrict on update restrict;
create index ix_supplier_mealOverlayModel_44 on supplier (meal_overlay_model_id);
alter table supplier add constraint fk_supplier_additionalInformation_45 foreign key (additional_information_id) references hotel_additional_information (id) on delete restrict on update restrict;
create index ix_supplier_additionalInformation_45 on supplier (additional_information_id);
alter table supplier add constraint fk_supplier_additionalMandatoryInfo_46 foreign key (additional_mandatory_info_id) references hotel_additional_mandatory_info (id) on delete restrict on update restrict;
create index ix_supplier_additionalMandatoryInfo_46 on supplier (additional_mandatory_info_id);
alter table user add constraint fk_user_supplierObject_47 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_user_supplierObject_47 on user (supplier_object_id);
alter table yield_mgmt_model add constraint fk_yield_mgmt_model_supplierObject_48 foreign key (supplier_object_id) references supplier (id) on delete restrict on update restrict;
create index ix_yield_mgmt_model_supplierObject_48 on yield_mgmt_model (supplier_object_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table allottment_market;

drop table area_attraction_model;

drop table business_communication_model;

drop table cctvstatus;

drop table cancellation_section;

drop table cancellation_section1;

drop table country;

drop table currency;

drop table day;

drop table hotel_additional_information;

drop table hotel_additional_mandatory_info;

drop table hotel_amenities;

drop table hotel_amenities_model;

drop table hotel_billing_information_model;

drop table hotel_business_amenities;

drop table hotel_business_amenities_model;

drop table hotel_chain;

drop table hotel_contact_information_model;

drop table hotel_description_modal;

drop table hotel_description_options;

drop table hotel_health_safety_model;

drop table hotel_image;

drop table hotel_internal_information_model;

drop table hotel_leisure_amenities;

drop table hotel_leisure_amenities_model;

drop table hotel_location_area;

drop table hotel_location_model;

drop table hotel_transportation_model;

drop table market_rate_policy;

drop table meal_overlay_model;

drop table months;

drop table night_life;

drop table profie_general_information_model;

drop table province;

drop table repeat_child_meal_rate_sections;

drop table repeat_mandatory_sections;

drop table repeat_mandatory_sections1;

drop table repeat_rate_sections;

drop table repeat_supplement_sections;

drop table repeat_tax_sections;

drop table room_amenity;

drop table room_type_model;

drop table salutation;

drop table shopping_facility;

drop table supplier;

drop table supplier_code;

drop table time;

drop table user;

drop table year;

drop table yield_mgmt_model;

SET FOREIGN_KEY_CHECKS=1;

