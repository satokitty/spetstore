package com.j5ik2o.spetstore.domain.item

import com.j5ik2o.spetstore.infrastructure.support.RepositoryOnMemory

/**
 * [[com.j5ik2o.spetstore.domain.item.ItemType]]のためのオンメモリリポジトリ。
 *
 * @param entities エンティティの集合
 */
private[item]
class ItemTypeRepositoryOnMemory(entities: Map[ItemTypeId, ItemType])
  extends RepositoryOnMemory[ItemTypeId, ItemType](entities) with ItemTypeRepository {

  type This = ItemTypeRepository

  protected def createInstance(entities: Map[ItemTypeId, ItemType]): This =
    new ItemTypeRepositoryOnMemory(entities)

}