## Description:
A nostalgic Java game where the player evades AI enemies on a randomly generated map to reach a target point. Implemented with Maven, featuring configurable settings and distinct game and AI logic projects.

### Gameplay:
- Generate a random map with obstacles.
- Place player, enemies, and target point randomly.
- The player moves towards the target while evading enemies.

### Rules:
- Players and enemies take turns moving.
- The player wins by reaching the target before enemies reach them.
- Moves are left, right, up, and down.
- If surrounded or unable to move, the player loses.
- Enemies and target points do not overlap.

### Implementation Requirements:

Field size, number of obstacles, and enemies are set via command line:
