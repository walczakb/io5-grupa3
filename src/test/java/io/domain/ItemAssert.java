package io.domain;

import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class ItemAssert extends AbstractAssert<ItemAssert, Item> {
    public ItemAssert(Item item) { super(item, ItemAssert.class); }
    public static ItemAssert assertThat(Item item) { return new ItemAssert(item); }

    public ItemAssert hasData(String name, int count, int price) {
        if (!Objects.equals(name, actual.name())) failWithMessage(
                "Expecting items's name to be <%s> but was <%s>",
                name, actual.name());
        if (count != actual.count()) failWithMessage(
                "Expecting items's count to be <%s> but was <%s>",
                count, actual.count());
        if (count != actual.count()) failWithMessage(
                "Expecting items's price to be <%s> but was <%s>",
                price, actual.price());
        return this;
    }
}
