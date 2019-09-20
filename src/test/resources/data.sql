INSERT INTO gif (
    `owner_id`,
    `title`,
    `fixed_height_url`,
    `fixed_height_width`,
    `fixed_height_height`,
    `fixed_height_small_still_url`,
    `fixed_height_small_still_width`,
    `fixed_height_small_still_height`,
    `original_url`,
    `original_width`,
    `original_height`
)
VALUES (
    1,
    'Fun cat gif',
    'http://localhost:8080/fixed-height-url',
    10,
    10,
    'http://localhost:8080/fixed-height-small-still-url',
    10,
    10,
    'http://localhost:8080/original-url',
    10,
    10
);
