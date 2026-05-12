INSERT INTO habits (habit_name, category, description, frequency, created_date)
SELECT 'Drink Water', 'Health', 'Drink 8 glasses of water', 'Daily', CURDATE()
WHERE NOT EXISTS (SELECT 1 FROM habits WHERE habit_name = 'Drink Water');

INSERT INTO habits (habit_name, category, description, frequency, created_date)
SELECT 'Study Java', 'Study', 'Practice Java for 1 hour', 'Daily', CURDATE()
WHERE NOT EXISTS (SELECT 1 FROM habits WHERE habit_name = 'Study Java');
