package sk.eworks.eshoptryout;

import sk.eworks.eshoptryout.table.ShoppingItem;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public abstract class Utils {
    private static final TableSchema<ShoppingItem> shoppingItemTableSchema = TableSchema.fromBean(ShoppingItem.class);
    private final DynamoDbClient dynamoDbClient = DynamoDbClient.builder().region(Region.EU_CENTRAL_1).build();
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient = DynamoDbEnhancedClient.builder().dynamoDbClient(dynamoDbClient).build();
    private final DynamoDbTable<ShoppingItem> shoppingItemTable = dynamoDbEnhancedClient.table(ShoppingItem.class.getSimpleName(), shoppingItemTableSchema);

    public DynamoDbTable<ShoppingItem> getShoppingItemTable() {
        return shoppingItemTable;
    }
}
