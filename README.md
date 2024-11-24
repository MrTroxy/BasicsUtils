# BasicsUtils

![Plugin Logo](https://github.com/MrTroxy/BasicsUtils/blob/main/logo.png)

**BasicsUtils** is a versatile Minecraft plugin designed for 1.21.1, offering a suite of essential commands and features for both players and staff members. Enhance your server management and player experience with intuitive commands and customizable configurations.

## Features

### Player Commands
- `/gamemode <type> [player]`: Change your or another player's game mode.
- `/tpa <player>`: Send a teleport request to another player.
- `/trash`: Open a trash menu to dispose of unwanted items.

### Staff Commands
- `/god [player]`: Toggle god mode for yourself or another player, preventing damage and hunger loss.
- `/openinv <player>`: View and edit another player's inventory.
- `/enderchest [player]`: Access a player's ender chest.
- `/fix`: Repair the item in your hand to full durability.

## Permissions

Ensure proper permissions are set for each command to maintain server security and functionality.

| Permission                      | Description                                      | Default |
| ------------------------------- | ------------------------------------------------ | ------- |
| `basicsUtils.gamemode`          | Use `/gamemode` command                          | OP      |
| `basicsUtils.gamemode.others`   | Change other players' game modes                 | OP      |
| `basicsUtils.god`               | Toggle god mode                                  | OP      |
| `basicsUtils.god.others`        | Toggle god mode for other players                | OP      |
| `basicsUtils.openinv`           | Open another player's inventory                  | OP      |
| `basicsUtils.enderchest`        | Open another player's ender chest                | OP      |
| `basicsUtils.enderchest.others` | Open another player's ender chest (others)       | OP      |
| `basicsUtils.fix`               | Repair items using `/fix`                        | OP      |
| `basicsUtils.tpa`               | Send teleport requests using `/tpa`              | TRUE    |
| `basicsUtils.trash`             | Access the trash menu using `/trash`             | TRUE    |

## Installation

1. **Download the Plugin:**
   - Download the latest `BasicsUtils.jar` from the [Releases](https://github.com/MrTroxy/BasicsUtils/releases) page.

2. **Place in Plugins Folder:**
   - Move the `BasicsUtils.jar` file to your server's `plugins` directory.

3. **Start the Server:**
   - Start or restart your Paper server to generate the necessary configuration files.

4. **Configure:**
   - Navigate to `plugins/BasicsUtils/config.yml` to customize messages and settings as needed.

## Configuration

Customize all plugin messages and settings via the `config.yml` file.

```yaml
no_permission: "&cYou don't have permission to perform this command."
player_only: "&cOnly players can execute this command."
player_not_found: "&cPlayer not found."
usage_gamemode: "&cUsage: /gamemode <type> [player]"
invalid_gamemode: "&cInvalid gamemode type."
gamemode_set: "&aYour gamemode has been set to {mode}."
gamemode_set_other: "&aYou have set {player}'s gamemode to {mode}."
usage_openinv: "&cUsage: /openinv <player>"
no_item_in_hand: "&cYou must be holding an item."
item_repaired: "&aYour item has been repaired."
tpa_request_sent: "&aTeleport request sent to {player}."
tpa_request_received: "&a{player} has requested to teleport to you. Type /tpaccept or /tpdeny."
no_tpa_request: "&cYou have no pending teleport requests."
tpa_request_accepted: "&aTeleport request accepted."
tpa_request_acceptor: "&aYou have accepted the teleport request."
tpa_request_denied: "&cTeleport request denied."
tpa_request_denied_sender: "&cYou have denied the teleport request."
godmode_enabled: "&aGod mode enabled."
godmode_disabled: "&cGod mode disabled."
godmode_enabled_other: "&aGod mode enabled for {player}."
godmode_disabled_other: "&cGod mode disabled for {player}."
```

## Usage

### Gamemode Command

- Set your gamemode: `gamemode <type>`
- Set another player's gamemode: `gamemode <type> [player]`

### God Mode Command

- Toggle your god mode: `god`
- Toggle another player's god mode: `god [player]`

### Open Inventory Command

- Open another player's inventory: `openinv <player>`

### Ender Chest Command

- Open your ender chest: `enderchest`
- Open another player's ender chest: `enderchest [player]`

### Fix Command

- Repair item in hand: `fix`

### TPA Command

- Send teleport request: `tpa <player>`
- Accept teleport request: `tpaccept`
- Deny teleport request: `tpdeny`

### Trash Command

- Open trash menu: `trash`

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the Repository
2. Create a Feature Branch
``git checkout -b feature/YourFeature``
3. Commit Your Changes
``git commit -m "Add YourFeature"``
4. Push to the Branch
``git push origin feature/YourFeature``
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Support

For support, open an issue on GitHub.