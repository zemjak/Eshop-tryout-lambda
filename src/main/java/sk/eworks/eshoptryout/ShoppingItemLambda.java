package sk.eworks.eshoptryout;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.eworks.eshoptryout.table.ShoppingItem;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShoppingItemLambda extends Utils {

    public void fillDatabaseFromJsonFile(Context context) {
        LambdaLogger logger = context.getLogger();

        try (FileReader reader = new FileReader("productList.json")) {
            ShoppingItem[] shoppingItems = new ObjectMapper().readValue(reader, ShoppingItem[].class);
            Arrays.stream(shoppingItems).forEach(shoppingItem -> getShoppingItemTable().putItem(shoppingItem));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ShoppingItem> getAllShoppingItems(Map<String, String> request, Context context) {
        List<ShoppingItem> itemList = new ArrayList<>();
        getShoppingItemTable().scan().forEach(shoppingItemPage -> itemList.addAll(shoppingItemPage.items()));
        return itemList.stream().sorted(Comparator.comparing(ShoppingItem::getName)).toList();
    }

    public ShoppingItem getShoppingItem(Map<String, String> request, Context context) {
        return getShoppingItemTable().getItem(Key.builder().partitionValue(request.get("guid")).build());
    }
}
