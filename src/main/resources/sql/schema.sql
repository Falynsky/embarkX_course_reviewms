CREATE SEQUENCE review_seq
    INCREMENT BY 1
    MINVALUE 1
    START WITH 1
    CACHE 10;

CREATE TABLE review (
                        id BIGINT PRIMARY KEY UNIQUE DEFAULT nextval('review_seq'),
                        review TEXT NOT NULL,
                        description TEXT NOT NULL,
                        rating DOUBLE PRECISION NOT NULL,
                        company_id  BIGINT       NOT NULL,
                        version BIGINT       NOT NULL
);