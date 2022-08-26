<template>
  <div>
    <h1>{{ testMsg }}</h1>
    <li v-for="(item, index) in lists" :key=index>
      {{ item }}
    </li>
    <button v-on:click="clickHandler">클릭해봐!</button>
    <input v-model="initMsg">
    <p>{{ initMsg }}</p><br/>

    <button v-on:click="show=!show">쇼타임!</button>
    <p v-if="show">보였다 안보였다</p><br/>
    <p>{{ lists[1] }}</p><br/>
    <p>{{ lists[0] }}</p><br/>
    <p>{{ lists[2] }}</p><br/>
    <p>{{ lists[num] }}</p><br/>

    <p>{{ count }} 번 클릭했습니다.</p>
    <button v-on:click="increment">카운트 버튼</button><br/>

    <p>캐릭터 상태 창</p>
    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>

    <!-- 현재 컨텐츠 측면에서 몬스터가 매번 같은것이 추가되서 재미 요소가 반감됨(그러므로 랜덤 요소를 넣어야함) -->
    (고정)몬스터 이름: <input v-model="name">
    <button v-on:click="addFixedMonster">고정 몬스터 추가하기</button><br/>

    <button v-on:click="addRandomMonster">랜덤 몬스터 추가하기</button><br/>

    <button v-on:click="addManyRandomMonster">랜덤 몬스터 100마리 추가하기</button><br/>

    <ul>
      <li v-for="(monster, index) in monsterLists" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
        <!-- 병맛 감성 스킬명 -->
        <button v-on:click="darknessDeathDestinyTypoonBlade(index)">
          Darkness Death Destiny Typoon Blade
        </button>
        <button v-on:click="removeMonster(index)">맵에 끼어 있는 몬스터 삭제하기</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Test",
  data() {
    return {
      name: "키메라",
      testMsg: "My Message",
      lists: ['apple', 'banana', 'grape'],
      initMsg: "양방향으로 맵핑이 가능함",
      show: true,
      num: 1,
      count: 0,
      monsterBooks: [
        { monsterId: 1, name: '슬라임', hp: 50, exp: 10, dropMoney: 5 },
        { monsterId: 2, name: '고블린', hp: 100, exp: 20, dropMoney: 10 },
        { monsterId: 3, name: '놀', hp: 200, exp: 40, dropMoney: 20 },
        { monsterId: 4, name: '멧돼지', hp: 400, exp: 100, dropMoney: 20 },
        { monsterId: 5, name: '스켈레톤', hp: 350, exp: 90, dropMoney: 10 },
        { monsterId: 6, name: '오크', hp: 550, exp: 150, dropMoney: 40 },
        { monsterId: 7, name: '홉고블린', hp: 650, exp: 180, dropMoney: 50 },
        { monsterId: 8, name: '스켈레톤 아처', hp: 300, exp: 150, dropMoney: 50 },
        { monsterId: 9, name: '트롤', hp: 800, exp: 200, dropMoney: 80 },
        { monsterId: 10, name: '좀비', hp: 350, exp: 90, dropMoney: 50 },
        { monsterId: 11, name: '고블린 매지션', hp: 700, exp: 500, dropMoney: 300 },
        { monsterId: 12, name: '오우거', hp: 1000, exp: 250, dropMoney: 50 },
        { monsterId: 13, name: '고스트', hp: 750, exp: 300, dropMoney: 1 },
        { monsterId: 14, name: '골렘', hp: 2000, exp: 400, dropMoney: 100 },
        { monsterId: 15, name: '와이번', hp: 3500, exp: 500, dropMoney: 150 },
        { monsterId: 16, name: '리치', hp: 2000, exp: 1000, dropMoney: 500 },
        { monsterId: 17, name: '스켈레톤 기사', hp: 2500, exp: 700, dropMoney: 100 },
        { monsterId: 18, name: '웨어울프', hp: 5000, exp: 1000, dropMoney: 700 },
        { monsterId: 19, name: '미노타우루스', hp: 10000, exp: 1500, dropMoney: 1000 },
        { monsterId: 20, name: '드레이크', hp: 20000, exp: 5000, dropMoney: 50000 },
        { monsterId: 21, name: '죽음의 군주', hp: 1000000, exp: 200000, dropMoney: 1000000 },
      ],
      monsterLists: [
        { id: 1, name: '슬라임', hp: 50 },
        { id: 2, name: '고블린', hp: 100 },
        { id: 3, name: '놀', hp: 200 },
      ],
      characterStatus: {
        level: 1,
        hp: 50,
        mp: 30,
        itemAtk: 0,
        defaultAtk: 10,
        atk: 10,
        str: 10,
        intelligence: 10,
        dex: 10,
        vit: 10,
        def: 10,
        men: 0,
        totalLevelBar: 10,
        currentLevelBar: 0,
        money: 0,
        currentJob: '모험가'
      },
    }
  },
  methods: {
    // clickHandler (event) {
    clickHandler: function (event) {
      alert("이벤트 발생: " + event.target)
    },
    // increment: function () {
    increment () {
      this.count += 1
    },
    findCurrentMonsterListMax() {
      return this.monsterLists.reduce(
          (a, b) => { console.log("a: " + a + ", b.id: " + b.id); return a > b.id ? a : b.id },
          0)
    },
    addFixedMonster () {
      // let은 javascript에서 사용하는 변수 개념입니다.
      // java에서 Object와 유사
      let max = this.findCurrentMonsterListMax()

      this.monsterLists.push({
        id: max + 1,
        name: this.name,
        hp: 500
      })
    },
    removeMonster (index) {
      // 새로운 개념: splice는 ?
      // 리스트에서 index 파트를 특정 개수만큼 잘라낸다.
      // splice(index, 1)이므로 index에 해당하는 정보 1개를 삭제한다라는 뜻입니다.
      this.monsterLists.splice(index, 1)
    },
    addRandomMonster () {
      let max = this.findCurrentMonsterListMax()

      // ex) 20개라면 0 ~ 19.xxx 까지인데 floor 버림이니까 0 ~ 19까지
      let randomMonsterBookIdx = Math.floor(Math.random() * this.monsterBooks.length)

      this.monsterLists.push({
        id: max + 1,
        name: this.monsterBooks[randomMonsterBookIdx].name,
        hp: this.monsterBooks[randomMonsterBookIdx].hp
      })
    },
    addManyRandomMonster () {
      for (let i = 0; i < 100; i++) {
        this.addRandomMonster()
      }
    },
    darknessDeathDestinyTypoonBlade (index) {
      console.log("어둠의 다크에서 죽음의 데스를 느끼며 서쪽에서 불어오는 태풍을 맞으니 " +
        "간닷! 다크니스 데스 데스티니 타이푼 블레이드!!!!!!!!!!!")

      this.monsterLists[index].hp =
          this.monsterLists[index].hp -
          Math.floor(
              this.characterStatus.atk * 70 +
              this.characterStatus.str * 33 +
              this.characterStatus.dex * 30 +
              this.characterStatus.intelligence * 30
          )
    }
  },
  beforeUpdate() {
    console.log("나는 VDOM의 변화를 감지하면 무조건 동작해!")

    let i

    for (i = 0; i < this.monsterLists.length; i++) {
      if (this.monsterLists[i].hp <= 0) {
        for (let j = 0; j < this.monsterBooks.length; j++) {
          if (this.monsterLists[i].name === this.monsterBooks[j].name) {
            this.characterStatus.currentLevelBar += this.monsterBooks[j].exp
            this.characterStatus.money += this.monsterBooks[j].dropMoney
          }
        }
        this.monsterLists.splice(i, 1)
      }
    }
  }
}
</script>

<style scoped>

</style>