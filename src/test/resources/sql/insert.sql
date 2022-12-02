DROP TABLE IF EXISTS `RECIPE`;

CREATE TABLE RECIPE
(
    ID          INTEGER PRIMARY KEY AUTO_INCREMENT,
    NAME        VARCHAR(255)  NOT NULL,
    IS_VEGETARIAN     BOOLEAN,
    DESCRIPTION VARCHAR(2000) NOT NULL,
    INGREDIENTS VARCHAR(2000) NOT NULL,
    DIRECTIONS  VARCHAR(2000) NOT NULL,
    SERVINGS    INT           NOT NULL,
    PREP_TIME   INT           NOT NULL
);


INSERT INTO RECIPE (NAME, IS_VEGETARIAN, DESCRIPTION, INGREDIENTS, DIRECTIONS, SERVINGS, PREP_TIME)
VALUES ('Chicken Parmesan',
        0,
        'Chicken Parmesan is a classic Italian-American dish that is easy to make at home. It is a simple dish of breaded chicken cutlets topped with tomato sauce and melted mozzarella cheese.',
        '1/2 cup all-purpose flour, 2 eggs, beaten, 1 cup Italian-style bread crumbs, 1/2 teaspoon salt, 1/4 teaspoon ground black pepper, 4 skinless, boneless chicken breast halves - pounded 1/4 inch thick, 1/2 cup grated Parmesan cheese, 1 (24 ounce) jar pasta sauce, 1 cup shredded mozzarella cheese',
        'Preheat oven to 350 degrees F (175 degrees C). Place flour in a shallow dish. Beat eggs in a separate shallow dish. Mix bread crumbs, salt, and pepper together in a third shallow dish. Dip chicken into flour, then into egg, and finally into bread crumb mixture to coat. Place chicken in a 9x13 inch baking dish. Sprinkle Parmesan cheese over chicken. Pour pasta sauce over chicken. Cover with aluminum foil. Bake in the preheated oven for 30 minutes. Remove foil, and sprinkle mozzarella cheese over chicken. Bake uncovered for 15 minutes, or until chicken is no longer pink and juices run clear.',
        4, 45);
INSERT INTO RECIPE (NAME, IS_VEGETARIAN, DESCRIPTION, INGREDIENTS, DIRECTIONS, SERVINGS, PREP_TIME)
VALUES ('Chicken Cordon Bleu',
        0,
        'Chicken Cordon Bleu is a classic French dish that is easy to make at home. It is a simple dish of breaded chicken cutlets stuffed with ham and Swiss cheese, then topped with a creamy Dijon sauce.',
        '1/2 cup all-purpose flour, 2 eggs, beaten, 1 cup Italian-style bread crumbs, 1/2 teaspoon salt, 1/4 teaspoon ground black pepper, 4 skinless, boneless chicken breast halves - pounded 1/4 inch thick, 4 slices Swiss cheese, 4 slices ham, 1/2 cup butter, 1/2 cup all-purpose flour, 1 cup chicken broth, 1/2 cup heavy cream, 1/4 cup Dijon mustard',
        'Preheat oven to 350 degrees F (175 degrees C). Place flour in a shallow dish. Beat eggs in a separate shallow dish. Mix bread crumbs, salt, and pepper together in a third shallow dish. Dip chicken into flour, then into egg, and finally into bread crumb mixture to coat. Place chicken in a 9x13 inch baking dish. Top each chicken breast with a slice of Swiss cheese and a slice of ham. Bake in the preheated oven for 30 minutes. Meanwhile, melt butter in a saucepan over medium heat. Stir in flour until smooth, and cook 1 minute. Gradually stir in chicken broth and cream. Bring to a boil, and cook until thickened, about 5 minutes. Stir in Dijon mustard. Serve sauce over chicken.',
        4, 45);
INSERT INTO RECIPE (NAME, IS_VEGETARIAN, DESCRIPTION, INGREDIENTS, DIRECTIONS, SERVINGS, PREP_TIME)
VALUES ( 'Veg Pasta',
        1,
        'Veg Pasta is a classic Italian-American dish that is easy to make at home. It is a simple dish of breaded chicken cutlets topped with tomato sauce and melted mozzarella cheese.',
        '1/2 cup all-purpose flour, 2 eggs, beaten, 1 cup Italian-style bread crumbs, 1/2 teaspoon salt, 1/4 teaspoon ground black pepper, 4 skinless, boneless chicken breast halves - pounded 1/4 inch thick, 1/2 cup grated Parmesan cheese, 1 (24 ounce) jar pasta sauce, 1 cup shredded mozzarella cheese',
        'Preheat oven to 350 degrees F (175 degrees C). Place flour in a shallow dish. Beat eggs in a separate shallow dish. Mix bread crumbs, salt, and pepper together in a third shallow dish. Dip chicken into flour, then into egg, and finally into bread crumb mixture to coat. Place chicken in a 9x13 inch baking dish. Sprinkle Parmesan cheese over chicken. Pour pasta sauce over chicken. Cover with aluminum foil. Bake in the preheated oven for 30 minutes. Remove foil, and sprinkle mozzarella cheese over chicken. Bake uncovered for 15 minutes, or until chicken is no longer pink and juices run clear.',
        4, 45);
INSERT INTO RECIPE (NAME, IS_VEGETARIAN, DESCRIPTION, INGREDIENTS, DIRECTIONS, SERVINGS, PREP_TIME)
VALUES ('Veg Curry',
        1,
        'Veg Curry is a classic French dish that is easy to make at home. It is a simple dish of breaded chicken cutlets stuffed with ham and Swiss cheese, then topped with a creamy Dijon sauce.',
        '1/2 cup all-purpose flour, 2 eggs, beaten, 1 cup Italian-style bread crumbs, 1/2 teaspoon salt, 1/4 teaspoon ground black pepper, 4 skinless, boneless chicken breast halves - pounded 1/4 inch thick, 4 slices Swiss cheese, 4 slices ham, 1/2 cup butter, 1/2 cup all-purpose flour, 1 cup chicken broth, 1/2 cup heavy cream, 1/4 cup Dijon mustard',
        'Preheat oven to 350 degrees F (175 degrees C). Place flour in a shallow dish. Beat eggs in a separate shallow dish. Mix bread crumbs, salt, and pepper together in a third shallow dish. Dip chicken into flour, then into egg, and finally into bread crumb mixture to coat. Place chicken in a 9x13 inch baking dish. Top each chicken breast with a slice of Swiss cheese and a slice of ham. Bake in the preheated oven for 30 minutes. Meanwhile, melt butter in a saucepan over medium heat. Stir in flour until smooth, and cook 1 minute. Gradually stir in chicken broth and cream. Bring to a boil, and cook until thickened, about 5 minutes. Stir in Dijon mustard. Serve sauce over chicken.',
        4, 45);
