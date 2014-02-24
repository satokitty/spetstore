package com.github.j5ik2o.spetstore.domain.model.pet

import com.github.j5ik2o.spetstore.domain.infrastructure.support.{EntityIOContext, Entity}
import scala.util.Try
import com.github.j5ik2o.spetstore.domain.model.basic.SexType

/**
 * ペットを表すエンティティ。
 *
 * @param id 識別子
 * @param petTypeId [[com.github.j5ik2o.spetstore.domain.model.pet.PetTypeId]]
 * @param name 名前
 * @param description 説明
 * @param price 価格
 */
case class Pet
(id: PetId = PetId(),
 petTypeId: PetTypeId,
 name: String,
 sexType: SexType.Value,
 description: Option[String] = None,
 price: BigDecimal,
 supplierId: SupplierId)
  extends Entity[PetId] {

  /**
   * [[com.github.j5ik2o.spetstore.domain.model.pet.PetType]]を取得する。
   *
   * @param ptr [[com.github.j5ik2o.spetstore.domain.model.pet.PetTypeRepository]]
   * @param ctx [[com.github.j5ik2o.spetstore.domain.infrastructure.support.EntityIOContext]]
   * @return `Try`にラップされた[[com.github.j5ik2o.spetstore.domain.model.pet.PetType]]
   */
  def petType(implicit ptr: PetTypeRepository, ctx: EntityIOContext): Try[PetType] =
    ptr.resolveEntity(petTypeId)

}


