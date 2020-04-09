package problem1.answer;

import problem1.answer.impl.Flash;
import problem1.answer.impl.MissileAttack;
import problem1.answer.impl.TripleHitAttack;
import problem1.answer.impl.Walk;

public class Client {
    /**
     *  다음 문제에 답하고 조건에 맞게 리팩토링하세요.
     *
     *  A) 기존 로봇의 공격 또는 이동 방법을 수정하려면 어떤 변경 작업을 해야 하는가? 예를 들어 아톰이 날 수는 없고 오직 걷게만 만들고 싶다면? 또는 태권V를 날게 하려면?
     *      A-1) SOLID의 어떤 원칙을 위배하는 설계인가요?
     *
     *      변경1) 해당 로봇클래스의 move, attack 메서드를 직접 수정해야한다.
     *      이는 변경에 닫혀있지 않으므로 OCP에 위배된다.(확장에 열려있고 변경에 닫혀있어야 함)
     *
     *  B) 새로운 로봇을 만들어 기존의 공격 또는 이동 방법을 추가하거나 수정하려면? 예를 들어 새로운 로봇으로 지구의 용사 선가드를 만들어 태권V의 미사일 공격 기능을 추가하려면?
     *      B-1) 이때 어떠한 문제가 발생할까요?
     *
     *      변경1) 새로운 로봇 클래스(선가드)를 만들어 로봇 클래스를 상속받아서 구현하면 되므로 확장에는 열려있다고 할 수 있다
     *      하지만 기존의 미사일 기능을 추가할 경우 코드의 중복이 발생한다.
     *      이러한 코드의 중복은 산탄총 수술을 야기하는 버그의 원인이 된다.
     *
     *  C) 문제를 해결하기 위해선 무엇을 해야할까요?
     *      해결) 변하는 부분을 찾아 추상화한다. 여기서 변하는 부분은 공격전략, 움직임 전략이다.
     *      로봇 클래스가 구체적인 구현체에 의존하지 않고 추상화된 인터페이스에 의존하게 만듬으로써
     *      새로운 전략이 추가되어도 기존의 소스에는 영향을 받지 않게 만들 수 있다.
     */

    public static void main(String[] args) {
        TaekwonV taekwonV = new TaekwonV("좁밥태권V");
        taekwonV.setAttackStrategy(new MissileAttack());
        taekwonV.setMovingStrategy(new Walk());
        Atom atom = new Atom("짱쎈 아톰");
        atom.setAttackStrategy(new TripleHitAttack());
        atom.setMovingStrategy(new Flash());

        System.out.println("--태권V--");
        taekwonV.attack();
        taekwonV.move();
        System.out.println("--아톰--");
        atom.attack();
        atom.move();
    }

    /**
     * 스트래티지 패턴에 대한 정리
     *
     *  A) 스트래티지 패턴은 무슨 패턴인가요?
     *      전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴.
     *      전략이란, 어떤 목적을 달성하기 위해 일을 수행하는 방식, 비즈니스 규칙, 문제를 해결하는 알고리즘 등을 말한다.
     *
     *  B) 종이를 꺼내 스트래피지 패턴의 클래스 다이어그램을 그려보세요. 그리고 구성요소에 대해 설명해보세요.
     *      답은 책 177 페이지.
     *
     *
     *
     */
}
