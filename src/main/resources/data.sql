INSERT INTO oauth_client_details (
    `client_id`,
    `client_secret`,
    `scope`,
    `authorized_grant_types`,
    `authorities`,
    `access_token_validity`,
    `refresh_token_validity`
)
VALUES (
    'admin',
    '{noop}password',
    'read,write,trust',
    'password,refresh_token',
    'ROLE_USER',
    900,
    2592000
);
INSERT INTO oauth_client_details (
    `client_id`,
    `client_secret`,
    `scope`,
    `authorized_grant_types`,
    `authorities`,
    `access_token_validity`,
    `refresh_token_validity`
)
VALUES (
    'admin2',
    '{bcrypt}$2a$04$nGjf/uX4dmGx4fgvVPdlQu7ji1LA7wECj09abDpdv9etc9kmg9hT2',
    'read,write,trust',
    'password,refresh_token',
    'ROLE_USER',
    900,
    2592000
);

