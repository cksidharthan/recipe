-- noinspection SqlNoDataSourceInspectionForFile
DROP TABLE IF EXISTS `RECIPE`;

CREATE TABLE RECIPE
(
    ID            INTEGER PRIMARY KEY AUTO_INCREMENT,
    IS_VEGETARIAN BOOLEAN,
    NAME          VARCHAR(255)  NOT NULL,
    DESCRIPTION   VARCHAR(2000) NOT NULL,
    INGREDIENTS   VARCHAR(2000) NOT NULL,
    DIRECTIONS    VARCHAR(2000) NOT NULL,
    SERVINGS      INT           NOT NULL,
    PREP_TIME     INT           NOT NULL
);
