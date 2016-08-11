CREATE TABLE IF NOT EXISTS public.provider
(
  id bigint NOT NULL,
  first_name character varying(255),
  last_name character varying(255),
  salutation character varying(255),
  telno character varying(255),
  mobile_number character varying(255),
  created TIMESTAMP,
  created_by bigint,
  updated TIMESTAMP,
  updated_by bigint,
  CONSTRAINT provider_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.provider_location
(
  id bigint NOT NULL,
  provider_id bigint NOT NULL,
  location_id bigint NOT NULL,
  created TIMESTAMP,
  created_by bigint,
  updated TIMESTAMP,
  updated_by bigint,
  CONSTRAINT provider_location_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.location
(
  id bigint NOT NULL,
  location_name character varying(255),
  address1 character varying(255),
  address2 character varying(255),
  city character varying(255),
  state_province character varying(255),
  postal_code character varying(255),
  country character varying(255),
  main_number character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  salutation character varying(255),
  created TIMESTAMP,
  created_by bigint,
  updated TIMESTAMP,
  updated_by bigint,
  CONSTRAINT location_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.appointment
(
  id bigint NOT NULL,
  provider_id bigint NOT NULL,
  patient_id bigint NOT NULL,
  location_id bigint NOT NULL,
  start_time  TIMESTAMP,
  end_time    TIMESTAMP,
  notes character varying(255),
  cancelled boolean,
  created TIMESTAMP,
  created_by bigint,
  updated TIMESTAMP,
  updated_by bigint,
  CONSTRAINT appointment_pkey PRIMARY KEY (id)
);
