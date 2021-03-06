package Arrangement;

import Model.Employee.Employee;
import Model.Shift;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Arrangement
{
    private List<Shift> m_Shifts;

    public Arrangement() {
        this.m_Shifts = new ArrayList<>();
    }

    public Arrangement(List<Shift> shifts) {
        this.m_Shifts = shifts;
    }

    public Arrangement(Arrangement arrangement) {
        /* DEEP CLONE */
        List<Shift> shifts = arrangement.getShifts();
        this.m_Shifts = new ArrayList<>();
        for (Shift shift : shifts) {
            this.m_Shifts.add(new Shift(
                    shift.getEmployee(),
                    shift.getRole(),
                    shift.getSlot()
            ));
        }
    }

    public Set<Employee> getWorkingEmp(){
        Set<Employee> allemp = new HashSet<>();
        for(Shift shift: m_Shifts){
            allemp.add(shift.getEmployee());
        }
        return allemp;
    }

    public void addShift(Shift shift)
    {
        m_Shifts.add(shift);
    }

    public List<Shift> getShifts() {
        return m_Shifts;
    }

    public ArrayList<DayOfWeek> getDaysOfWorkForEmployee(Employee employee)
    {
        ArrayList<DayOfWeek> daysOfWork = new ArrayList<>();
        ArrayList<Boolean> days = new ArrayList<>(7);

        for(int i = 0;i < 7;i++)
            days.add(false);

        for(Shift shift : m_Shifts)
            days.set(shift.getSlot().getDay().getValue() - 1 , true);

        for(int i = 0;i < 7;i++)
            if(days.get(i))
                daysOfWork.add(DayOfWeek.of(i + 1));

        return daysOfWork;
    }

    public ArrayList<Shift> getShiftsByDay(DayOfWeek day)
    {
        ArrayList<Shift> shifts = new ArrayList<>();

        for(int i=0;i < this.m_Shifts.size();i++)
        {
            if(this.m_Shifts.get(i).getSlot().getDay().equals(day))
            {
                shifts.add(this.m_Shifts.get(i));
            }
        }

        return shifts;
    }

    public int size() {
        return m_Shifts.size();
    }

    public ArrayList<DayOfWeek> getWorkDays()
    {
        Set<DayOfWeek> days = new HashSet<>();

        for(Shift shift : m_Shifts){
            days.add(shift.getSlot().getDay());
        }

        return new ArrayList<>(days);
    }

    /* public Arrangement(ArrayList<Map.Entry<Integer, ArrayList<Integer>>> daysOfWork2Levels, ArrayList<ArrayList<Shift>> arrangement)
    {
        m_DaysOfWork2Levels = daysOfWork2Levels;
        m_Arrangement = arrangement;
    }

    public Arrangement(ArrayList<Map.Entry<Integer, ArrayList<Integer>>> daysOfWork2Levels)
    {
        m_DaysOfWork2Levels = daysOfWork2Levels;
        for (int i = 0;i < m_DaysOfWork2Levels.size();i++)
        {
            m_Arrangement.add(new ArrayList<>());
        }
    }

    public ArrayList<Map.Entry<Integer, ArrayList<Integer>>> getDaysOfWork2Levels() {return m_DaysOfWork2Levels;}
    public ArrayList<Shift> getArrangement(int day)
    {
        int index = 0;
        while(true)
        {
          if(m_DaysOfWork2Levels.get(index).getKey() == day)
              break;
          else
              index++;
        }

        return m_Arrangement.get(index);
    }
    public ArrayList<ArrayList<Shift>> getArrangement() {return m_Arrangement;}
    public void setArrangement(int day, ArrayList<Shift> arrayShifts)
    {
        int index = 0;
        while(true)
        {
            if(m_DaysOfWork2Levels.get(index).getKey() == day)
                break;
            else
                index++;
        }

        m_Arrangement.set(index, arrayShifts);
    }
    public void setArrangement(ArrayList<ArrayList<Shift>> arrangement) {this.m_Arrangement = arrangement;}
    public void setDaysOfWork(ArrayList<Map.Entry<Integer, ArrayList<Integer>>> daysOfWork2Levels) {this.m_DaysOfWork2Levels = daysOfWork2Levels;}

    @Override
    public String toString() {
        return "ArrangeShifts{" +
                "m_DaysOfWork=" + m_DaysOfWork2Levels +
                ", m_Arrangement=" + m_Arrangement +
                '}';
    }*/
}
